package ru.riddle.phVLofSuTe.model.customComponents.properties.styleable;

import javafx.beans.property.ObjectProperty;
import javafx.scene.paint.Color;

public interface ColorableBody {

    Color getBodyColor();

    void setBodyColor(Color bodyColor);

    ObjectProperty<Color> bodyColorProperty();
}