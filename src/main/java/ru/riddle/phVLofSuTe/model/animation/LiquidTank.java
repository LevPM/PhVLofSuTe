package ru.riddle.phVLofSuTe.model.animation;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Group;
import ru.riddle.phVLofSuTe.model.experiments.Liquid;

public abstract class LiquidTank extends Group {

    private static final Liquid DEFAULT_LIQUID = Liquid.WATER;

    private ObjectProperty<Liquid> liquidType;

    public Liquid getLiquidType(){
        return (liquidType != null) ? liquidType.get() : DEFAULT_LIQUID;
    }

    public void setLiquidType(Liquid liquidType){
        if((this.liquidType != null)){
            if(!DEFAULT_LIQUID.equals(liquidType)){
                this.liquidType.set(liquidType);
            }
        }
    }

    public ObjectProperty<Liquid> liquidTypeProperty(){
        if(liquidType == null){
            liquidType = new SimpleObjectProperty<>(this, "liquidType", DEFAULT_LIQUID);
        }
        return liquidType;
    }
}
