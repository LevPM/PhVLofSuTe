package ru.riddle.phVLofSuTe.controller.model.customComponents;

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
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;
import ru.riddle.phVLofSuTe.controller.LiquidL;
import ru.riddle.phVLofSuTe.model.data.json.liquid.Liquid;
import ru.riddle.phVLofSuTe.viewModel.customComponents.Fillable;
import ru.riddle.phVLofSuTe.view.customComponents.properties.Segmentable;
import ru.riddle.phVLofSuTe.view.customComponents.properties.styleable.ColorableBody;
import ru.riddle.phVLofSuTe.model.FXMLs;
import ru.riddle.phVLofSuTe.model.ModelUtil;

import java.net.URL;
import java.util.*;

public class Syringe extends BorderedLiquidTank implements Initializable, Segmentable {

    private static final String DEFAULT_STYLE_CLASS = "syringe";

    private static final int SEGMENT_HEIGHT = 50;

    private IntegerProperty countOfSegments;
    private BooleanProperty isOpen;

    private static final PseudoClass OPENED_PSEUDOCLASS_STATE = PseudoClass.getPseudoClass("opened");
    private static final PseudoClass CLOSED_PSEUDOCLASS_STATE = PseudoClass.getPseudoClass("closed");

    private static final int DEFAULT_COUNT_OF_SEGMENTS = 5;
    private static final boolean DEFAULT_IS_OPEN = false;

    private LiquidBody liquid;
    private CylinderBody body;
    private PistonBody piston;

    private boolean isAnimating;

    private EventHandler<Event> onAnimationFinishedEventHandler;

    public Syringe(){
        ModelUtil.downloadCustomComponentFXML(FXMLs.SYRINGE, this);
        this.setFillableParts(liquid);
        this.liquidTypeProperty().addListener(event -> rebuildSyringe());
        this.getStyleClass().add(DEFAULT_STYLE_CLASS);
        this.pseudoClassStateChanged(CLOSED_PSEUDOCLASS_STATE, true);
    }

    private void buildSyringe(){
        liquid = new LiquidBody(this.getLiquidType());
        piston = new PistonBody(this.getIsOpen());
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
    public void initialize(URL location, ResourceBundle resources) {
        buildSyringe();
    }

    public void animateWithContainer(LiquidContainer container, Drop drop){
        if(!isAnimating){
            isAnimating = true;
            this.setLiquidType(container.getLiquidType());
            drop.setLiquidType(container.getLiquidType());
            Transition transition = getTransition(container, drop);
            transition.setOnFinished(event -> {
                isAnimating = false;
                if(onAnimationFinishedEventHandler !=  null){
                    onAnimationFinishedEventHandler.handle(null);
                }
            });
            transition.play();
        }

    }

    private Transition getTransition(LiquidContainer container, Drop drop){
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
        return new SequentialTransition(
                container.getTransition(Duration.seconds(3), false),
                getSyringeLoweringTransition(Duration.seconds(2), container, true),
                piston.getTransition(refillingDuration, true),
                getSyringeLoweringTransition(Duration.seconds(2), container, false),
                container.getTransition(Duration.seconds(3), true)
        );
    }

    private Transition getSyringeLoweringTransition(Duration duration, LiquidContainer container, boolean isLowering){
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(this);
        transition.setDuration(duration);
        double height = container.getTranslateY() - this.getTranslateY() - 48;
        transition.setByY(isLowering ? height : -height);
        return transition;
    }

    private Transition getDrippingTransition(Duration drippingDuration, Drop drop){
        return new ParallelTransition(drop.getTransition(drippingDuration), piston.getTransition(drippingDuration, false));
    }

    @Override
    public int getCountOfSegments(){
        return (countOfSegments != null) ? countOfSegments.get() : DEFAULT_COUNT_OF_SEGMENTS;
    }

    @Override
    public void setCountOfSegments(int countOfSegments){
        this.countOfSegmentsProperty().set(countOfSegments);
    }

    @Override
    public IntegerProperty countOfSegmentsProperty(){
        if(countOfSegments == null){
            countOfSegments = new SimpleIntegerProperty(this, "countOfSegments", DEFAULT_COUNT_OF_SEGMENTS);
            countOfSegments.addListener(event -> rebuildSyringe());
        }
        return countOfSegments;
    }

    public boolean getIsOpen(){
        return isOpenProperty().get();
    }

    public void setIsOpen(boolean isOpen){
        this.isOpenProperty().set(isOpen);
    }

    public BooleanProperty isOpenProperty(){
        if(isOpen == null){
            isOpen = new StyleableBooleanProperty(DEFAULT_IS_OPEN) {
                @Override
                protected void invalidated() {
                    boolean isClosed = this.get() == DEFAULT_IS_OPEN; //DEFAULT_IS_OPEN is closed
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
                    return StyleableProperties.IS_OPEN;
                }
            };
            isOpen.addListener(event -> piston.setIsOpen(getIsOpen()));
        }
        return isOpen;
    }

    public void setOnAnimationFinished(EventHandler<Event> handler){
        this.onAnimationFinishedEventHandler = handler;
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
                var styleables = new ArrayList<>(BorderedLiquidTank.getClassCssMetaData());
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

    private abstract class Body extends Group {

        private final double bodyHeight;

        private Body(FXMLs capFXML, FXMLs tipFXML, FXMLs segmentFXML){
            ModelUtil.downloadCustomComponentFXML(FXMLs.SYRINGE_BODY, this);
            bodyHeight = SEGMENT_HEIGHT * getCountOfSegments();
            build(capFXML, tipFXML, segmentFXML);
        }

        protected void build(FXMLs capFXML, FXMLs tipFXML, FXMLs segmentFXML){
            buildSegments(segmentFXML);
            this.getChildren().addAll(
                    new Cap(capFXML),
                    new Tip(tipFXML)
            );
        }

        protected void buildSegments(FXMLs segmentFXML){
            for(int i = 0; i < getCountOfSegments(); i++){
                this.getChildren().add(new Segment(segmentFXML, i, SEGMENT_HEIGHT));
            }
        }

        public double getBodyHeight() {
            return bodyHeight;
        }

        protected class Cap extends Group{
            public Cap(FXMLs capFXML){
                ModelUtil.downloadCustomComponentFXML(capFXML, this);
                this.setLayoutY(-bodyHeight - 10 + 0.5);
            }
        }

        protected class Segment extends Group{
            public Segment(FXMLs segmentFXML, int sequenceNumber, int segmentHeight) {
                ModelUtil.downloadCustomComponentFXML(segmentFXML, this);
                this.setLayoutY(-sequenceNumber * segmentHeight);
            }
        }

        protected class Tip extends Group{
            public Tip(FXMLs tipFXML) {
                ModelUtil.downloadCustomComponentFXML(tipFXML, this);
            }
        }
    }

    private class CylinderBody extends Body{
        public CylinderBody() {
            super(FXMLs.SYRINGE_BODY_STUB,FXMLs.SYRINGE_TIP, FXMLs.SYRINGE_BODY_SEGMENT);

            Node cap = this.getChildren().getFirst();
            cap.setLayoutY(cap.getLayoutY() + 0.5);
        }
    }

    private class PistonBody extends Body implements ColorableBody{

        private ObjectProperty<Color> bodyColor;

        private boolean isOpen = false;

        private final int openY; //Translate Y when syringe is open

        public PistonBody(boolean isOpen) {
            super(FXMLs.SYRINGE_PISTON_CAP, FXMLs.SYRINGE_PISTON_TIP, FXMLs. SYRINGE_PISTON_SEGMENT);
            this.getStyleClass().add("syringe-piston");

            this.openY = - SEGMENT_HEIGHT * (getCountOfSegments() - 1);

            this.setIsOpen(isOpen);
        }

        @Override
        protected void build(FXMLs capFXML, FXMLs tipFXML, FXMLs segmentFXML) {
            createBackground(getBodyHeight());
            super.build(capFXML, tipFXML, segmentFXML);
        }

        private void createBackground(double bodyHeight){
            Rectangle background = new Rectangle(60, bodyHeight, Color.GAINSBORO);
            background.getStyleClass().add("piston-background");
            background.setX(-30);
            background.setY(- bodyHeight - 11);
            background.setId("pistonRodBackground");
            this.getChildren().add(background);
        }

        public Transition getTransition(Duration duration, boolean isRefilling){
            if(isOpen && isRefilling){
                return new TranslateTransition();
            }

            TranslateTransition transition = new TranslateTransition();
            transition.setNode(this);
            transition.setDuration(Duration.millis(duration.toMillis() + 1000));
            transition.setByY(isRefilling ? openY : -openY);

            return transition;
        }

        private void open(){
            if(!isOpen) {
                if(!(this.getTranslateY() == openY)){
                    this.setTranslateY(openY);
                }
                this.isOpen = true;
            }
        }

        private void close(){
            if(isOpen) {
                if(!(this.getTranslateY() == 0)){
                    this.setTranslateY(this.getTranslateY() - openY);
                }
                this.isOpen = false;
            }
        }

        public boolean isOpen() {
            return isOpen;
        }

        public void setIsOpen(boolean isOpen) {
            if(isOpen != this.isOpen){
                if(isOpen){
                    open();
                } else {
                    close();
                }
            }
        }

        @Override
        public Color getBodyColor() {
            return bodyColorProperty().get();
        }

        @Override
        public void setBodyColor(Color bodyColor) {
            this.bodyColorProperty().set(bodyColor);
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

                bodyColor.addListener(event -> this.recolor());
            }
            return this.bodyColor;
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

        private void recolor(){
            colorGroup(this, getBodyColor());
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
                    var styleables = new ArrayList<>(Group.getClassCssMetaData());
                    Collections.addAll(styleables,
                            BODY_COLOR
                    );
                    STYLEABLES = Collections.unmodifiableList(styleables);
                }
            }
        }
    }

    public class LiquidBody extends Body implements Fillable {

        private final Liquid liquidType;

        public LiquidBody(Liquid liquidType) {
            super(FXMLs.NULL, FXMLs.SYRINGE_LIQUID_TIP, FXMLs.SYRINGE_LIQUID_SEGMENT);
            this.liquidType = liquidType;
            build(liquidType);
            this.setLayoutX(-30);
            this.setLayoutY(-60);
        }

        @Override
        public void fill(Color color) {
            this.getChildren().forEach(children -> {
                if(children instanceof Fillable fillable){
                    fillable.fill(color);
                }
            });
        }

        @Override
        protected void build(FXMLs capFXML, FXMLs tipFXML, FXMLs segmentFXML) {}

        private void build(Liquid liquidType){
            this.getChildren().addAll(
                    new LiquidTip(liquidType)
            );
            buildSegments(liquidType);
        }

        private void buildSegments(Liquid liquidType){
            for(int i = 0; i < getCountOfSegments(); i++){
                this.getChildren().add(new LiquidSegment(i, SEGMENT_HEIGHT, liquidType));
            }
        }

        @Override
        protected void buildSegments(FXMLs segmentFXML) {}

        private class LiquidTip extends Tip implements Fillable{

            private final Liquid liquidType;

            @FXML
            private Polygon liquid;

            public LiquidTip(Liquid liquidType) {
                super(FXMLs.SYRINGE_LIQUID_TIP);
                this.liquidType = liquidType;
                this.liquid.setFill(liquidType.color());
            }

            @Override
            public void fill(Color color) {
                liquid.setFill(color);
            }
        }

        private class LiquidSegment extends Segment implements  Fillable{

            private final Liquid liquidType;

            @FXML
            private Rectangle liquid;

            public LiquidSegment(int sequenceNumber, int segmentHeight, Liquid liquidType) {
                super(FXMLs.SYRINGE_LIQUID_SEGMENT, sequenceNumber, segmentHeight);
                this.liquidType = liquidType;
                liquid.setFill(liquidType.color());
            }

            @Override
            public void fill(Color color) {
                liquid.setFill(color);
            }
        }
    }
}
