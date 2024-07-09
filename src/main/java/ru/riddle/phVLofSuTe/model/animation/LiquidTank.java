package ru.riddle.phVLofSuTe.model.animation;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Group;
import javafx.scene.shape.Shape;
import ru.riddle.phVLofSuTe.model.experiments.Liquid;

import java.util.Arrays;
import java.util.List;

public abstract class LiquidTank extends Group {

    private static final Liquid DEFAULT_LIQUID = Liquid.WATER;

    private ObjectProperty<Liquid> liquidType;

    private List<Shape> liquidParts;

    public final Liquid getLiquidType(){
        return (liquidTypeProperty() != null) ? liquidType.get() : DEFAULT_LIQUID;
    }

    public final void setLiquidType(Liquid liquidType){
        this.liquidTypeProperty().set(liquidType);
    }

    public final ObjectProperty<Liquid> liquidTypeProperty(){
        if(liquidType == null){
            liquidType = new SimpleObjectProperty<>(this, "liquidType", DEFAULT_LIQUID);
            liquidType.addListener(event -> fillParts());
        }
        return this.liquidType;
    }

    protected void setLiquidParts(Shape... shapes) {
        this.liquidParts = Arrays.asList(shapes);
        fillParts();
    }

    private void fillParts(){
        liquidParts.forEach(part -> part.setFill(this.getLiquidType().getColor()));
    }
}
