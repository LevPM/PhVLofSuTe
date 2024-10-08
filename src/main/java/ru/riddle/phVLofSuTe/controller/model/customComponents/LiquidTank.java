package ru.riddle.phVLofSuTe.controller.model.customComponents;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Group;
import javafx.scene.shape.Shape;
import ru.riddle.phVLofSuTe.model.data.json.liquid.Liquid;
import ru.riddle.phVLofSuTe.view.customComponents.Fillable;
import ru.riddle.phVLofSuTe.view.customComponents.properties.LiquidTypeable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Deprecated
public abstract class LiquidTank extends Group implements LiquidTypeable {

    private static final Liquid DEFAULT_LIQUID = null;

    private ObjectProperty<Liquid> liquidType;

    private List<Shape> shapeParts;
    private List<Fillable> fillableParts;
    //We need to lists of parts for classic javafx components and custom components

    public LiquidTank(){
        shapeParts = new ArrayList<>();
        fillableParts = new ArrayList<>();
    }

    @Override
    public final Liquid getLiquidType(){
        return (liquidTypeProperty() != null) ? liquidType.get() : DEFAULT_LIQUID;
    }

    @Override
    public final void setLiquidType(Liquid liquidType){
        this.liquidTypeProperty().set(liquidType);
    }

    @Override
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
        shapeParts.forEach(part -> part.setFill(this.getLiquidType().color()));
        fillableParts.forEach(part -> part.fill(this.getLiquidType().color()));
    }
}
