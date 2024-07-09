package ru.riddle.phVLofSuTe.model.animation;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Group;
import ru.riddle.phVLofSuTe.model.experiments.Liquid;

public abstract class LiquidTank extends Group {

    private static final Liquid DEFAULT_LIQUID = Liquid.WATER;

    private ObjectProperty<Liquid> liquidType;

    public final Liquid getLiquidType(){
        return (liquidTypeProperty() != null) ? liquidType.get() : DEFAULT_LIQUID;
    }

    public final void setLiquidType(Liquid liquidType){
        this.liquidTypeProperty().set(liquidType);
    }

    public final ObjectProperty<Liquid> liquidTypeProperty(){
        if(liquidType == null){
            liquidType = new SimpleObjectProperty<>(this, "liquidType", DEFAULT_LIQUID);
        }
        return this.liquidType;
    }
}
