package ru.riddle.phVLofSuTe.model.experiments.syringe;

import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.shape.Arc;
import javafx.util.Duration;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.util.LiquidTank;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

public class Drop extends LiquidTank {

    @FXML
    private Arc dropTip;

    @FXML
    private Arc dropCircle;

    public Drop(){
        ModelUtil.downloadCustomComponentFXML(FXMLs.DROP, this);
        dropTip.setFill(this.getLiquidType().getColor());
        dropCircle.setFill(this.getLiquidType().getColor());
        this.setScaleX(0.5);
        this.setScaleY(0.5);
    }

    public Transition getTransition(Duration entireDuration){
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(this);
        transition.setDuration(Duration.millis(entireDuration.toMillis()/this.getLiquidType().getAmountOfDrops()));
        transition.setByY(100);
        transition.setCycleCount(this.getLiquidType().getAmountOfDrops());
        transition.setOnFinished(event -> this.setLayoutY(this.getLayoutY() - 100));

        return transition;
    }
}
