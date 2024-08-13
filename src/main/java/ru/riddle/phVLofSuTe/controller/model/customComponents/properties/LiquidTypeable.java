package ru.riddle.phVLofSuTe.controller.model.customComponents.properties;

import javafx.beans.property.ObjectProperty;
import ru.riddle.phVLofSuTe.controller.model.customComponents.Liquid;

public interface LiquidTypeable {
    Liquid getLiquidType();

    void setLiquidType(Liquid liquidType);

    ObjectProperty<Liquid> liquidTypeProperty();
}
