package ru.riddle.phVLofSuTe.model.experiments.syringe;

import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.util.LiquidContainer;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

public class Drop extends LiquidContainer {

    public Drop(){
        ModelUtil.downloadCustomComponentFXML(FXMLs.DROP, this);
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
