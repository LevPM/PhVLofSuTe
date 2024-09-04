package ru.riddle.phVLofSuTe.view.customComponents;

import de.saxsys.mvvmfx.FxmlPath;
import de.saxsys.mvvmfx.FxmlView;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.beans.property.*;
import javafx.css.*;
import javafx.css.converter.BooleanConverter;
import javafx.css.converter.ColorConverter;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.InjectViewModel;
import ru.riddle.phVLofSuTe.model.data.json.liquid.Liquid;
import ru.riddle.phVLofSuTe.model.view.ViewManager;
import ru.riddle.phVLofSuTe.view.customComponents.properties.Openable;
import ru.riddle.phVLofSuTe.view.customComponents.properties.Segmentable;
import ru.riddle.phVLofSuTe.view.customComponents.properties.styleable.ColorableBody;
import ru.riddle.phVLofSuTe.viewModel.customComponents.SyringeViewModel;

import java.net.URL;
import java.util.*;

@FxmlPath("/ru/riddle/phVLoSuTe/view/customComponents/syringe/Syringe.fxml")
public class Syringe extends BorderedLiquidTankView<SyringeViewModel> implements Segmentable, Initializable, Openable {

    private static final Logger syringeLogger = LoggerFactory.getLogger(Syringe.class);

    @InjectViewModel
    private SyringeViewModel viewModel;

    private final IntegerProperty countOfSegmentsProperty = new SimpleIntegerProperty();
    private BooleanProperty isOpen = new SimpleBooleanProperty();

    private LiquidBody liquid;
    private CylinderBody body;
    private PistonBody piston;

    private final BooleanProperty isAnimating = new SimpleBooleanProperty();

    private static final PseudoClass OPENED_PSEUDOCLASS_STATE = PseudoClass.getPseudoClass("opened");
    private static final PseudoClass CLOSED_PSEUDOCLASS_STATE = PseudoClass.getPseudoClass("closed");

    private EventHandler<Event> onAnimationFinishedEventHandler;

    public Syringe() {
        syringeLogger.trace("Creating syringe...");
        ViewManager.downloadCustomComponent(this, Syringe.class);
        this.getStyleClass().add("syringe");
        this.liquidTypeProperty().addListener(event -> rebuildSyringe());
        this.setFillableParts(liquid);
        this.pseudoClassStateChanged(CLOSED_PSEUDOCLASS_STATE, true);
    }

    private void buildSyringe(){
        syringeLogger.trace("Building syringe...");
        liquid = new LiquidBody();
        piston = new PistonBody(isOpen.get());
        body = new CylinderBody();

        this.setColoredGroup(body);

        this.getChildren().addAll(
                liquid,
                piston,
                body
        );
        this.recolor();
    }

    private void rebuildSyringe(){
        this.getChildren().clear();
        buildSyringe();
    }

    @Override
    public int getCountOfSegments() {
        return countOfSegmentsProperty().get();
    }

    @Override
    public void setCountOfSegments(int countOfSegments) {
        countOfSegmentsProperty().set(countOfSegments);
    }

    @Override
    public IntegerProperty countOfSegmentsProperty() {
        return countOfSegmentsProperty;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        syringeLogger.trace("Initializing Syringe...");
        countOfSegmentsProperty.bind(viewModel.countOfSegmentsProperty());
        isOpen.bindBidirectional(viewModel.isOpenProperty());
    }

    @Override
    public boolean getIsOpen() {
        return isOpenProperty().get();
    }

    @Override
    public void setIsOpen(boolean isOpen) {
        isOpenProperty().set(isOpen);
    }

    @Override
    public BooleanProperty isOpenProperty() {
        if(isOpen == null) {
            isOpen = new StyleableBooleanProperty() {
                @Override
                protected void invalidated() {
                    boolean isClosed = !this.get();
                    Syringe.this.pseudoClassStateChanged(CLOSED_PSEUDOCLASS_STATE, isClosed);
                    Syringe.this.pseudoClassStateChanged(OPENED_PSEUDOCLASS_STATE, !isClosed);
                }

                @Override
                public Object getBean() {
                    return Syringe.this;
                }

                @Override
                public String getName() {
                    return "isOpen";
                }

                @Override
                public CssMetaData<? extends Styleable, Boolean> getCssMetaData() {
                    return null;
                }
            };
            isOpen.addListener(event -> piston.setIsOpen(getIsOpen()));
        }
        return isOpen;
    }

    public void setOnAnimationFinished(EventHandler<Event> handler){
        this.onAnimationFinishedEventHandler = handler;
    }

    public void animateWithContainer(LiquidContainer container, Drop drop){
        syringeLogger.debug("Animating with container and drop...");
        if(!isAnimating.get()){
            isAnimating.set(true);
            this.setLiquidType(container.getLiquidType());
            drop.setLiquidType(container.getLiquidType());
            Transition transition = getTransition(container, drop);
            transition.setOnFinished(event -> {
                isAnimating.set(false);
                if(onAnimationFinishedEventHandler !=  null){
                    onAnimationFinishedEventHandler.handle(null);
                }
            });
            syringeLogger.info("Starting syringe animation...");
            transition.play();
        }
    }

    private Transition getTransition(LiquidContainer container, Drop drop){
        syringeLogger.trace("Getting Transition...");
        Duration drippingDuration = Duration.seconds(20);
        Duration refillingDuration = Duration.seconds(10);

        if(getIsOpen()){
            Transition drippingTransition = getDrippingTransition(drippingDuration, drop);
            drippingTransition.setOnFinished(event -> setIsOpen(false));
            return new SequentialTransition(drippingTransition);
        }

        return new SequentialTransition(
                getRefillingTransition(container, refillingDuration),
                getDrippingTransition(drippingDuration, drop)
        );
    }

    private Transition getRefillingTransition(LiquidContainer container, Duration refillingDuration){
        syringeLogger.trace("Getting refilling transition...");
        return new SequentialTransition(
                container.getTransition(Duration.seconds(3), false),
                getSyringeLoweringTransition(Duration.seconds(2), container, true),
                piston.getTransition(refillingDuration, true),
                getSyringeLoweringTransition(Duration.seconds(2), container, false),
                container.getTransition(Duration.seconds(3), true)
        );
    }

    private Transition getSyringeLoweringTransition(Duration duration, LiquidContainer container, boolean isLowering){
        syringeLogger.trace("Getting lowering transition");
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(this);
        transition.setDuration(duration);
        double height = container.getTranslateY() - this.getTranslateY() - 48;
        transition.setByY(isLowering ? height : -height);
        return transition;
    }

    private Transition getDrippingTransition(Duration drippingDuration, Drop drop){
        syringeLogger.trace("Getting dripping transition");
        return new ParallelTransition(drop.getTransition(drippingDuration), piston.getTransition(drippingDuration, false));
    }

    private static class StyleableProperties{
        private static final List<CssMetaData<? extends Styleable, ?>> STYLEABLES;

        private static final CssMetaData<Syringe, Boolean> IS_OPEN;

        static{
            IS_OPEN = new CssMetaData<>("-rl-is-open", BooleanConverter.getInstance(), true, true) {
                @Override
                public boolean isSettable(Syringe syringe) {
                    return !syringe.isOpenProperty().isBound();
                }

                @Override
                public StyleableProperty<Boolean> getStyleableProperty(Syringe syringe) {
                    return (StyleableProperty<Boolean>) syringe.isOpenProperty();
                }
            };

            {
                var styleables = new ArrayList<>(BorderedLiquidTankView.getClassCssMetaData());
                Collections.addAll(styleables,
                        IS_OPEN
                );
                STYLEABLES = Collections.unmodifiableList(styleables);
            }
        }
    }

    public static List<CssMetaData<? extends Styleable, ?>> getClassCssMetaData() {
        return Syringe.StyleableProperties.STYLEABLES;
    }

    @Override
    public List<CssMetaData<? extends Styleable, ?>> getCssMetaData() {
        return getClassCssMetaData();
    }


    private abstract class Body<B extends SyringeViewModel.BodyViewModel> extends Group implements FxmlView<SyringeViewModel.BodyViewModel> {


        private static final Logger bodyLogger = LoggerFactory.getLogger(Body.class);
        private final double bodyHeight;

        @InjectViewModel
        protected B bodyViewModel;

        public Body(){
            bodyHeight = SyringeViewModel.SEGMENT_HEIGHT * viewModel.countOfSegmentsProperty().get();
        }

        protected <
                C extends Cap<? extends SyringeViewModel.BodyViewModel.CapViewModel>,
                S extends Segment<? extends SyringeViewModel.BodyViewModel.SegmentViewModel>,
                T extends Tip<? extends SyringeViewModel.BodyViewModel.TipViewModel>
                > void build(C cap, List<S> segments, T tip){

            bodyLogger.trace("Building syringe body. Cap: {}, Segment: {} Tip: {}",
                    cap.getClass().getSimpleName(),
                    segments.getFirst().getClass().getSimpleName(),
                    tip.getClass().getSimpleName()
            );
            this.getChildren().addAll(cap, tip);
            segments.forEach(segment -> this.getChildren().add(segment));
        }

        public abstract void build();

        protected double getBodyHeight(){
            return bodyHeight;
        }

        protected abstract class Cap<C extends SyringeViewModel.BodyViewModel.CapViewModel> extends Group implements FxmlView<SyringeViewModel.BodyViewModel.CapViewModel>, Initializable {

            @InjectViewModel
            protected C capViewModel;

            @Override
            public void initialize(URL url, ResourceBundle resourceBundle) {
                this.setLayoutY(-bodyHeight - 10.5);
            }
        }

        protected abstract static class Segment<S extends SyringeViewModel.BodyViewModel.SegmentViewModel> extends Group implements FxmlView<SyringeViewModel.BodyViewModel.SegmentViewModel>, Initializable{

            private final IntegerProperty sequenceNumber = new SimpleIntegerProperty();

            @InjectViewModel
            protected S segmentViewModel;

            public Segment(int sequenceNumber) {
                this.sequenceNumber.set(sequenceNumber);
            }

            @Override
            public void initialize(URL url, ResourceBundle resourceBundle) {
                sequenceNumber.bindBidirectional(segmentViewModel.sequenceNumberProperty());
                this.setLayoutY(-segmentViewModel.sequenceNumberProperty().get() * SyringeViewModel.SEGMENT_HEIGHT);
            }

            protected IntegerProperty sequenceNumberProperty() {
                return sequenceNumber;
            }
        }

        protected abstract static class Tip<T extends SyringeViewModel.BodyViewModel.TipViewModel> extends Group implements FxmlView<SyringeViewModel.BodyViewModel.TipViewModel>{

            @InjectViewModel
            protected T tipViewModel;
        }
    }

    @FxmlPath("/ru/riddle/phVLofSuTe/view/customComponents/syringe/body/Body.fxml")
    private class CylinderBody extends Body<SyringeViewModel.BodyViewModel>{

        public CylinderBody() {
            ViewManager.downloadCustomComponent(this, CylinderBody.class);
        }

        @FxmlPath("/ru/riddle/phVLofSuTe/view/customComponents/syringe/body/Stub.fxml")
        private class CylinderCap extends Cap<SyringeViewModel.BodyViewModel.CapViewModel>{
            public CylinderCap(){
                ViewManager.downloadCustomComponent(this, CylinderCap.class);
                this.getChildren().getFirst().setLayoutY(this.getLayoutY() + 0.5);
            }
        }

        @FxmlPath("/ru/riddle/phVLofSuTe/view/customComponents/syringe/body/Segment.fxml")
        private static class CylinderSegment extends Segment<SyringeViewModel.BodyViewModel.SegmentViewModel>{
            public CylinderSegment(int sequenceNumber){
                super(sequenceNumber);
                ViewManager.downloadCustomComponent(this, CylinderSegment.class);
            }
        }

        @FxmlPath("/ru/riddle/phVLofSuTe/view/customComponents/syringe/body/Tip.fxml")
        private static class CylinderTip extends Tip<SyringeViewModel.BodyViewModel.TipViewModel>{
            public CylinderTip(){
                ViewManager.downloadCustomComponent(this, CylinderTip.class);
            }
        }

        public void build() {
            List<CylinderSegment> segments = new ArrayList<>();
            for(int i = 0; i < getCountOfSegments(); i++){
                segments.add(new CylinderSegment(i));
            }
            super.build(new CylinderCap(), segments, new CylinderTip());
        }
    }

    @FxmlPath("/ru/riddle/phVLofSuTe/view/customComponents/syringe/piston/PistonBody.fxml")
    private class PistonBody extends Body<SyringeViewModel.PistonBodyViewModel> implements ColorableBody, Openable, Initializable {

        Logger pistonLogger = LoggerFactory.getLogger(PistonBody.class);

        private ObjectProperty<Color> bodyColor; //styleable

        private final BooleanProperty isOpen = new SimpleBooleanProperty();
        private final DoubleProperty openY = new SimpleDoubleProperty();

        public PistonBody(boolean isOpen) {
            pistonLogger.trace("Creating piston body, isOpen: {}", isOpen);
            ViewManager.downloadCustomComponent(this, PistonBody.class);
            this.getStyleClass().add("syringe-piston");
            this.openY.set(-SyringeViewModel.SEGMENT_HEIGHT * (getCountOfSegments() - 1));
            this.setIsOpen(isOpen);
        }

        @Override
        public Color getBodyColor() {
            return bodyColorProperty().get();
        }

        @Override
        public void setBodyColor(Color bodyColor) {
            bodyColorProperty().set(bodyColor);
        }

        @Override
        public ObjectProperty<Color> bodyColorProperty() {
            if(this.bodyColor == null){
                bodyColor = new StyleableObjectProperty<>(Color.LIGHTGRAY) {
                    @Override
                    public Object getBean() {
                        return PistonBody.this;
                    }

                    @Override
                    public String getName() {
                        return "bodyColor";
                    }

                    @Override
                    public CssMetaData<? extends Styleable, Color> getCssMetaData() {
                        return PistonBody.StyleableProperties.BODY_COLOR;
                    }
                };

                bodyColor.addListener(event -> recolor());
            }
            return bodyColor;
        }

        @Override
        public boolean getIsOpen() {
            return isOpen.get();
        }

        @Override
        public void setIsOpen(boolean isOpen) {
            if(isOpen != this.getIsOpen()){
                if(isOpen){
                    open();
                } else {
                    close();
                }
            }
        }

        @Override
        public BooleanProperty isOpenProperty() {
            return isOpen;
        }

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            pistonLogger.trace("Initializing piston body");
            bodyColor.addListener(event -> this.recolor());
            bodyColor.bindBidirectional(bodyViewModel.bodyColorProperty());

            isOpen.bindBidirectional(bodyViewModel.isOpenProperty());
        }

        private void recolor(){
            colorGroup(this, getBodyColor());
        }

        private static void colorGroup(Group group, Color color){
            group.getChildren().forEach(child ->{
                if(child instanceof Group){
                    colorGroup((Group) child, color);
                }
                if(child instanceof Shape){
                    if(Objects.equals(child.getId(), "pistonRodBackground")) return;
                    ((Shape) child).setFill(color);
                }
            });
        }

        public void build(){
            List<PistonRodSegment> segments = new ArrayList<>();
            for(int i = 0; i < getCountOfSegments(); i++) {
                segments.add(new PistonRodSegment(i));
            }
            createBackground();
            super.build(new PistonCap(), segments, new PistonTip());
        }

        private void createBackground(){
            pistonLogger.trace("Creating background");
            Rectangle background = new Rectangle(60, getBodyHeight(), Color.GAINSBORO);
            background.getStyleClass().add("piston-background");
            background.setX(-30);
            background.setY(-getBodyHeight() - 11);
            background.setId("pistonRodBackground");
            this.getChildren().add(background);
        }

        public Transition getTransition(Duration duration, boolean isRefilling){
            pistonLogger.debug("Getting transition");
            if(getIsOpen() && isRefilling){
                return new TranslateTransition();
            }

            TranslateTransition transition = new TranslateTransition();
            transition.setNode(this);
            transition.setDuration(Duration.millis(duration.toMillis() + 1000));
            transition.setByY(isRefilling ? openY.get() : - openY.get());

            return transition;
        }

        public void open() {
            if(!getIsOpen()){
                if(!(this.getTranslateY() == openY.get())){
                    this.setTranslateY(openY.get());
                }
                pistonLogger.debug("Opening piston");
                this.isOpen.set(true);
            }
        }

        public void close() {
            if(getIsOpen()){
                if(!(this.getTranslateY() == 0)){
                    this.setTranslateY(this.getTranslateY() - openY.get());
                }
                pistonLogger.debug("Closing piston");
                this.isOpen.set(false);
            }
        }

        public static List<CssMetaData<? extends Styleable, ?>> getClassCssMetaData() {
            return PistonBody.StyleableProperties.STYLEABLES;
        }

        @Override
        public List<CssMetaData<? extends Styleable, ?>> getCssMetaData() {
            return getClassCssMetaData();
        }


        private static class StyleableProperties{
            private static final List<CssMetaData<? extends Styleable, ?>> STYLEABLES;

            private static final CssMetaData<PistonBody, Color> BODY_COLOR;

            static{
                BODY_COLOR = new CssMetaData<>("-rl-body-color", ColorConverter.getInstance(), Color.LIGHTGRAY, true) {
                    @Override
                    public boolean isSettable(PistonBody pistonBody) {
                        return !pistonBody.bodyColorProperty().isBound();
                    }

                    @Override
                    public StyleableProperty<Color> getStyleableProperty(PistonBody pistonBody) {
                        return (StyleableProperty<Color>) pistonBody.bodyColorProperty();
                    }
                };

                {
                    var styleables = new ArrayList<>(Body.getClassCssMetaData());
                    Collections.addAll(styleables,
                            BODY_COLOR
                    );
                    STYLEABLES = Collections.unmodifiableList(styleables);
                }
            }
        }

        @FxmlPath("/ru/riddle/phVLofSuTe/view/customComponents/syringe/piston/PistonCap.fxml")
        public class PistonCap extends Cap<SyringeViewModel.BodyViewModel.CapViewModel>{
            public PistonCap(){
                ViewManager.downloadCustomComponent(this, PistonCap.class);
            }
        }

        @FxmlPath("/ru/riddle/phVLofSuTe/view/customComponents/syringe/piston/PistonRodSegment.fxml")
        public static class PistonRodSegment extends Segment<SyringeViewModel.BodyViewModel.SegmentViewModel>{
            public PistonRodSegment(int sequenceNumber){
                super(sequenceNumber);
                ViewManager.downloadCustomComponent(this, PistonRodSegment.class);
            }
        }

        @FxmlPath("/ru/riddle/phVLofSuTe/view/customComponents/syringe/piston/PistonTip.fxml")
        public static class PistonTip extends Tip<SyringeViewModel.BodyViewModel.TipViewModel>{
            public PistonTip(){
                ViewManager.downloadCustomComponent(this, PistonTip.class);
            }
        }
    }

    @FxmlPath("/ru/riddle/phVLofSuTe/view/customComponents/syringe/liquid/Liquid.fxml")
    private class LiquidBody extends Body<SyringeViewModel.LiquidBodyViewModel> implements Fillable {

        Logger liquidLogger = LoggerFactory.getLogger(LiquidBody.class);

        private final ObjectProperty<Liquid> liquidType = new SimpleObjectProperty<>();

        public LiquidBody(){
            liquidLogger.trace("Creating liquid body");
            ViewManager.downloadCustomComponent(this, LiquidBody.class);
            this.liquidType.bind(viewModel.liquidTypeProperty());
        }

        @Override
        public void fill(Color color) {
            this.getChildren().forEach(child -> {
                if(child instanceof Fillable fillable) fillable.fill(color);
            });
        }

        @Override
        public void build() {
            List<LiquidSegment> segments = new ArrayList<>();
            for(int i = 0; i < getCountOfSegments(); i++) {
                segments.add(new LiquidSegment(i));
            }
            super.build(new LiquidCap(), segments, new LiquidTip());
        }

        public class LiquidCap extends Cap<SyringeViewModel.BodyViewModel.CapViewModel>{}

        @FxmlPath("/ru/riddle/phVLofSuTe/view/customComponents/syringe/liquid/LiquidSegment.fxml")
        public class LiquidSegment extends Segment<SyringeViewModel.BodyViewModel.SegmentViewModel> implements Fillable{

            @FXML
            private Rectangle liquid;

            public LiquidSegment(int sequenceNumber) {
                super(sequenceNumber);
                ViewManager.downloadCustomComponent(this, LiquidSegment.class);
                this.fill(getLiquidType().color());
            }

            @Override
            public void fill(Color color) {
                liquid.setFill(color);
            }
        }

        @FxmlPath("/ru/riddle/phVLofSuTe/view/customComponents/syringe/liquid/LiquidTip.fxml")
        public class LiquidTip extends Tip<SyringeViewModel.BodyViewModel.TipViewModel> implements Fillable{

            @FXML
            private Polygon liquid;

            public LiquidTip() {
                ViewManager.downloadCustomComponent(this, LiquidTip.class);
                this.fill(getLiquidType().color());
            }

            @Override
            public void fill(Color color) {
                liquid.setFill(color);
            }
        }
    }
}