package ru.riddle.phVLofSuTe.model.experiments.syringe;

import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

public class LiquidContainer extends ru.riddle.phVLofSuTe.model.util.LiquidContainer {

    @FXML
    private Polygon liquid;

    public LiquidContainer(){
        ModelUtil.downloadCustomComponentFXML(FXMLs.LIQUID_CONTAINER, this);
        liquid.setFill(this.getLiquidType().getColor());
    }

    public Transition getTransition(Duration duration, Syringe syringe, boolean isHiding){
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(this);
        transition.setByX(isHiding ? this.getTranslateX() : -this.getTranslateX());
        transition.setDuration(duration);

        return transition;
    }
}
