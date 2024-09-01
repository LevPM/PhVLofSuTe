package ru.riddle.phVLofSuTe.viewModel.customComponents.properties.styleable;

import javafx.scene.paint.Color;
import javafx.beans.property.ObjectProperty;

public interface ColorableBody {

    Color getBodyColor();

    void setBodyColor(Color bodyColor);

    ObjectProperty<Color> bodyColorProperty();
}