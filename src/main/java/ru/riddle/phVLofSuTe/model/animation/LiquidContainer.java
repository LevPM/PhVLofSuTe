package ru.riddle.phVLofSuTe.model.animation;

import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

public class LiquidContainer extends LiquidTank {

    @FXML
    private Polygon liquid;

    public LiquidContainer(){
        ModelUtil.downloadCustomComponentFXML(FXMLs.LIQUID_CONTAINER, this);
        this.setShapeParts(liquid);
    }

    public Transition getTransition(Duration duration, boolean isHiding){
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(this);
        transition.setByX(isHiding ? this.getTranslateX() : -this.getTranslateX());
        transition.setDuration(duration);

        return transition;
    }
}
