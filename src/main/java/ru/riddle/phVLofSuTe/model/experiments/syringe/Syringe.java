package ru.riddle.phVLofSuTe.model.experiments.syringe;

import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.fxml.Initializable;
import javafx.util.Duration;
import ru.riddle.phVLofSuTe.model.experiments.syringe.syringeBody.SyringeBody;
import ru.riddle.phVLofSuTe.model.experiments.syringe.syringeLiquid.SyringeLiquid;
import ru.riddle.phVLofSuTe.model.experiments.syringe.syringePiston.SyringePiston;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

import java.net.URL;
import java.util.ResourceBundle;

public class Syringe extends ru.riddle.phVLofSuTe.model.util.LiquidContainer implements Initializable {

    private static final int SEGMENT_HEIGHT = 50;

    int countOfSegments = 6; //default count of parts = 6

    private SyringeLiquid liquid;
    private SyringeBody body;
    private SyringePiston piston;

    private boolean isAnimating;

    public Syringe(){
        ModelUtil.downloadCustomComponentFXML(FXMLs.SYRINGE, this);
    }

    private void buildSyringe(){
        liquid = new SyringeLiquid(countOfSegments, SEGMENT_HEIGHT, this.getLiquidType());
        body = new SyringeBody(countOfSegments, SEGMENT_HEIGHT);
        piston = new SyringePiston(countOfSegments, SEGMENT_HEIGHT);

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
            transition.setOnFinished(event -> isAnimating = false);;
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
                container.getTransition(Duration.seconds(3), this, false),
                getSyringeLoweringTransition(Duration.seconds(2), container, true),
                piston.getTransition(refillingDuration, true),
                getSyringeLoweringTransition(Duration.seconds(2), container, false),
                container.getTransition(Duration.seconds(3), this, true)
        );
    }

    private Transition getSyringeLoweringTransition(Duration duration, LiquidContainer container, boolean isLowering){
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(this);
        transition.setDuration(duration);
        double height = container.getLayoutY() - this.getTranslateY() - 48;
        transition.setByY(isLowering ? height : -height);
        return transition;
    }

    private Transition getDrippingTransition(Duration drippingDuration, Drop drop){
        return new ParallelTransition(drop.getTransition(drippingDuration), piston.getTransition(drippingDuration, false));
    }
}
