package ru.riddle.phVLofSuTe.model.experiments.syringe;

import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.util.Duration;
import ru.riddle.phVLofSuTe.model.experiments.Liquid;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

public class Drop extends Group{

    private Liquid liquidType;

    public Drop(Liquid liquidType, double layoutX, double layoutY){
        this.liquidType = liquidType;
        ModelUtil.downloadCustomComponentFXML(FXMLs.DROP, this);
        this.setLayoutX(layoutX);
        this.setLayoutY(layoutY);
        this.setVisible(false);
    }

    public Transition getTransition(Duration entireDuration){
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(this);
        transition.setDuration(Duration.millis(entireDuration.toMillis()/liquidType.getAmountOfDrops()));
        transition.setByY(100);
        transition.setCycleCount(liquidType.getAmountOfDrops());
        transition.setOnFinished(event -> this.setLayoutY(this.getLayoutY() - 100));

        return transition;
    }
}
