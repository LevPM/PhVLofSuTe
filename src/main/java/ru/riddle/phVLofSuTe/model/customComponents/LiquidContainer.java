package ru.riddle.phVLofSuTe.model.customComponents;

import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.util.Duration;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

import java.util.Objects;

public class LiquidContainer extends BorderedLiquidTank {

    @FXML
    private Polygon liquid;

    public LiquidContainer(){
        ModelUtil.downloadCustomComponentFXML(FXMLs.LIQUID_CONTAINER, this);
        this.setShapeParts(liquid);
        this.getStyleClass().add("liquid-container");
    }

    @Override
    protected void colorShape(Shape shape, Color color) {
        if(Objects.equals(shape.getId(), liquid.getId())) return;
        super.colorShape(shape, color);
    }

    public Transition getTransition(Duration duration, boolean isHiding){
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(this);
        transition.setByX(isHiding ? this.getTranslateX() : -this.getTranslateX());
        transition.setDuration(duration);

        return transition;
    }
}
