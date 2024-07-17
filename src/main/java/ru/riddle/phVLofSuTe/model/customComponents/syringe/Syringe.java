package ru.riddle.phVLofSuTe.model.customComponents.syringe;

import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.util.Duration;
import ru.riddle.phVLofSuTe.model.customComponents.Drop;
import ru.riddle.phVLofSuTe.model.customComponents.LiquidContainer;
import ru.riddle.phVLofSuTe.model.customComponents.Segmentable;
import ru.riddle.phVLofSuTe.model.customComponents.syringe.syringeBody.SyringeBody;
import ru.riddle.phVLofSuTe.model.customComponents.syringe.syringeLiquid.SyringeLiquid;
import ru.riddle.phVLofSuTe.model.customComponents.syringe.syringePiston.SyringePiston;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.customComponents.LiquidTank;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

import java.net.URL;
import java.util.ResourceBundle;

public class Syringe extends LiquidTank implements Initializable, Segmentable {

    private static final int SEGMENT_HEIGHT = 50;

    private IntegerProperty countOfSegments;
    private BooleanProperty isOpen;

    private static final int DEFAULT_COUNT_OF_SEGMENTS = 5;
    private static final boolean DEFAULT_IS_OPEN = false;

    private SyringeLiquid liquid;
    private SyringeBody body;
    private SyringePiston piston;

    private boolean isAnimating;

    private EventHandler<Event> onAnimationFinishedEventHandler;

    public Syringe(){
        ModelUtil.downloadCustomComponentFXML(FXMLs.SYRINGE, this);
        this.setFillableParts(liquid);
        this.liquidTypeProperty().addListener(event -> rebuildSyringe());
    }

    private void buildSyringe(){
        liquid = new SyringeLiquid(getCountOfSegments(), SEGMENT_HEIGHT, this.getLiquidType());
        body = new SyringeBody(getCountOfSegments(), SEGMENT_HEIGHT);
        piston = new SyringePiston(getCountOfSegments(), SEGMENT_HEIGHT, getIsOpen());

        this.getChildren().addAll(
                liquid,
                piston,
                body
        );
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
            isOpen = new SimpleBooleanProperty(this, "isOpen", DEFAULT_IS_OPEN);
            isOpen.addListener(event -> piston.setIsOpen(getIsOpen()));
        }
        return isOpen;
    }

    public void setOnAnimationFinished(EventHandler<Event> handler){
        this.onAnimationFinishedEventHandler = handler;
    }
}
