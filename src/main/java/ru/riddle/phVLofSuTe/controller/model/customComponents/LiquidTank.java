package ru.riddle.phVLofSuTe.controller.model.customComponents;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Group;
import javafx.scene.shape.Shape;
import ru.riddle.phVLofSuTe.controller.LiquidL;
import ru.riddle.phVLofSuTe.viewModel.customComponents.Fillable;
import ru.riddle.phVLofSuTe.viewModel.customComponents.properties.LiquidTypeable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class LiquidTank extends Group implements LiquidTypeable {

    private static final LiquidL DEFAULT_LIQUID = LiquidL.WATER;

    private ObjectProperty<LiquidL> liquidType;

    private List<Shape> shapeParts;
    private List<Fillable> fillableParts;
    //We need to lists of parts for classic javafx components and custom components

    public LiquidTank(){
        shapeParts = new ArrayList<>();
        fillableParts = new ArrayList<>();
    }

    @Override
    public final LiquidL getLiquidType(){
        return (liquidTypeProperty() != null) ? liquidType.get() : DEFAULT_LIQUID;
    }

    @Override
    public final void setLiquidType(LiquidL liquidType){
        this.liquidTypeProperty().set(liquidType);
    }

    @Override
    public final ObjectProperty<LiquidL> liquidTypeProperty(){
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
