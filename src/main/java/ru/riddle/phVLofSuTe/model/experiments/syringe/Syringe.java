package ru.riddle.phVLofSuTe.model.experiments.syringe;

import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Transition;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import ru.riddle.phVLofSuTe.model.experiments.Liquid;
import ru.riddle.phVLofSuTe.model.experiments.syringe.syringeBody.SyringeBody;
import ru.riddle.phVLofSuTe.model.experiments.syringe.syringeLiquid.SyringeLiquid;
import ru.riddle.phVLofSuTe.model.experiments.syringe.syringePiston.SyringePiston;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

import java.net.URL;
import java.util.ResourceBundle;

public class Syringe extends AnchorPane implements Initializable {

    private static final int SEGMENT_HEIGHT = 50;

    int countOfSegments = 6; //default count of parts = 6

    private SyringeLiquid liquid;
    private SyringeBody body;
    private SyringePiston piston;

    private Liquid liquidType;

    private boolean isAnimating;

    public Syringe(){
        this.liquidType = Liquid.WATER;
        ModelUtil.downloadCustomComponentFXML(FXMLs.SYRINGE, this);
    }

    private void buildSyringe(){
        liquid = new SyringeLiquid(countOfSegments, SEGMENT_HEIGHT, liquidType);
        body = new SyringeBody(countOfSegments, SEGMENT_HEIGHT);
        piston = new SyringePiston(countOfSegments, SEGMENT_HEIGHT);

        this.getChildren().addAll(
                liquid,
                piston,
                body
        );
    }

    public boolean isAnimating() {
        return isAnimating;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buildSyringe();
    }

    public void animateWithContainer(LiquidContainer container){
        if(!isAnimating){
            isAnimating = true;
            Transition transition = getTransition(container);
            transition.setOnFinished(event -> isAnimating = false);
            transition.play();
        }

    }

    private Transition getTransition(LiquidContainer container){
        Duration drippingDuration = Duration.seconds(20);
        Duration refillingDuration = Duration.seconds(10);

        return new SequentialTransition(
                getRefillingTransition(container, refillingDuration),
                getDrippingTransition(drippingDuration)
        );
    }

    private Transition getRefillingTransition(LiquidContainer container, Duration refillingDuration){
        return new SequentialTransition(
                container.getTransition(Duration.seconds(3), this, false),
                piston.getTransition(refillingDuration, true),
                container.getTransition(Duration.seconds(3), this, true)
        );
    }

    private Transition getDrippingTransition(Duration drippingDuration){
        Drop drop = new Drop(liquidType, this.getTranslateX(), this.getTranslateY());
        return new ParallelTransition(drop.getTransition(drippingDuration), piston.getTransition(drippingDuration, false));
    }
}
