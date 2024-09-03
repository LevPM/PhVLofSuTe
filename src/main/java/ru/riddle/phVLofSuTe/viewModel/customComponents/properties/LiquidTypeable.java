package ru.riddle.phVLofSuTe.viewModel.customComponents.properties;

import javafx.beans.property.ObjectProperty;
import ru.riddle.phVLofSuTe.model.data.json.liquid.Liquid;

public interface LiquidTypeable {

    Liquid getLiquidType();

    void setLiquidType(Liquid liquidType);

    ObjectProperty<Liquid> liquidTypeProperty();
}
