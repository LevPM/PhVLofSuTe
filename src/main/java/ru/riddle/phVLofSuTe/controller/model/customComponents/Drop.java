package ru.riddle.phVLofSuTe.controller.model.customComponents;

import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.shape.Arc;
import javafx.util.Duration;
import ru.riddle.phVLofSuTe.model.FXMLs;
import ru.riddle.phVLofSuTe.model.ModelUtil;
@Deprecated
public class Drop extends LiquidTank {

    @FXML
    private Arc dropTip;

    @FXML
    private Arc dropCircle;

    public Drop(){
        ModelUtil.downloadCustomComponentFXML(FXMLs.DROP, this);
        this.setShapeParts(
                dropTip,
                dropCircle
        );
        this.setScaleX(0.5);
        this.setScaleY(0.5);
    }

    public Transition getTransition(Duration entireDuration){
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(this);
        transition.setDuration(Duration.millis(entireDuration.toMillis()/this.getLiquidType().amountOfDrops()));
        transition.setByY(100);
        transition.setCycleCount(this.getLiquidType().amountOfDrops());
        transition.setOnFinished(event -> this.setLayoutY(this.getLayoutY() - 100));

        return transition;
    }
}
