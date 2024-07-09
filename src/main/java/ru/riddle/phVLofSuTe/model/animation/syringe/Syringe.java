package ru.riddle.phVLofSuTe.model.animation.syringe;

import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.Initializable;
import javafx.util.Duration;
import ru.riddle.phVLofSuTe.model.animation.Drop;
import ru.riddle.phVLofSuTe.model.animation.LiquidContainer;
import ru.riddle.phVLofSuTe.model.animation.syringe.syringeBody.SyringeBody;
import ru.riddle.phVLofSuTe.model.animation.syringe.syringeLiquid.SyringeLiquid;
import ru.riddle.phVLofSuTe.model.animation.syringe.syringePiston.SyringePiston;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.animation.LiquidTank;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

import java.net.URL;
import java.util.ResourceBundle;

public class Syringe extends LiquidTank implements Initializable {

    private static final int SEGMENT_HEIGHT = 50;

    IntegerProperty countOfSegments;

    private static final int DEFAULT_COUNT_OF_SEGMENTS = 6;

    private SyringeLiquid liquid;
    private SyringeBody body;
    private SyringePiston piston;

    private boolean isAnimating;

    public Syringe(){
        ModelUtil.downloadCustomComponentFXML(FXMLs.SYRINGE, this);
    }

    private void buildSyringe(){
        liquid = new SyringeLiquid(getCountOfSegments(), SEGMENT_HEIGHT, this.getLiquidType());
        body = new SyringeBody(getCountOfSegments(), SEGMENT_HEIGHT);
        piston = new SyringePiston(getCountOfSegments(), SEGMENT_HEIGHT);

        this.getChildren().addAll(
                liquid,
                piston,
                body
        );
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buildSyringe();
    }

    public void animateWithContainer(LiquidContainer container, Drop drop){
        if(!isAnimating){
            isAnimating = true;
            Transition transition = getTransition(container, drop);
            transition.setOnFinished(event -> isAnimating = false);
            transition.play();
        }

    }

    private Transition getTransition(LiquidContainer container, Drop drop){
        Duration drippingDuration = Duration.seconds(20);
        Duration refillingDuration = Duration.seconds(10);

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

    public int getCountOfSegments(){
        return (countOfSegments != null) ? countOfSegments.get() : DEFAULT_COUNT_OF_SEGMENTS;
    }

    public void setCountOfSegments(int countOfSegments){
        this.countOfSegmentsProperty().set(countOfSegments);
    }

    public IntegerProperty countOfSegmentsProperty(){
        if(countOfSegments == null){
            countOfSegments = new SimpleIntegerProperty(this, "countOfSegments", DEFAULT_COUNT_OF_SEGMENTS);
        }
        return countOfSegments;
    }
}
