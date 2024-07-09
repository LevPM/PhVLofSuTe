package ru.riddle.phVLofSuTe.model.animation;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Group;
import javafx.scene.shape.Shape;
import ru.riddle.phVLofSuTe.model.experiments.Liquid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class LiquidTank extends Group {

    private static final Liquid DEFAULT_LIQUID = Liquid.WATER;

    private ObjectProperty<Liquid> liquidType;

    private List<Shape> shapeParts;
    private List<Fillable> fillableParts;
    //We need to lists of parts for classic javafx components and custom components

    public LiquidTank(){
        shapeParts = new ArrayList<>();
        fillableParts = new ArrayList<>();
    }

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

    protected void setShapeParts(Shape... shapes){
        this.shapeParts = Arrays.asList(shapes);
        fillParts();
    }

    protected void setFillableParts(Fillable... fillableParts){
        this.fillableParts = Arrays.asList(fillableParts);
        fillParts();
    }

    private void fillParts(){
        shapeParts.forEach(part -> part.setFill(this.getLiquidType().getColor()));
        fillableParts.forEach(part -> part.fill(this.getLiquidType().getColor()));
    }
}
