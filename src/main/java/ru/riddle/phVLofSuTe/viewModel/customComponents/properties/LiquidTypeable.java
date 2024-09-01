package ru.riddle.phVLofSuTe.viewModel.customComponents.properties;

import javafx.beans.property.ObjectProperty;
import ru.riddle.phVLofSuTe.viewModel.customComponents.LiquidL;

public interface LiquidTypeable {

    LiquidL getLiquidType();

    void setLiquidType(LiquidL liquidType);

    ObjectProperty<LiquidL> liquidTypeProperty();
}
