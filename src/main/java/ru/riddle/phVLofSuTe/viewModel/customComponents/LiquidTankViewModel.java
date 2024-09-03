package ru.riddle.phVLofSuTe.viewModel.customComponents;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.ViewModel;
import ru.riddle.phVLofSuTe.model.data.json.liquid.Liquid;
import ru.riddle.phVLofSuTe.model.data.json.liquid.LiquidManager;
import ru.riddle.phVLofSuTe.viewModel.customComponents.properties.LiquidTypeable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LiquidTankViewModel implements ViewModel, LiquidTypeable {

    private static final Logger logger = LoggerFactory.getLogger(LiquidTankViewModel.class);

    private static final Liquid DEFAULT_LIQUID = LiquidManager.getLiquid("Water");

    private ObjectProperty<Liquid> liquidType;

    private List<Fillable> fillableParts;

    {
        fillableParts = new ArrayList<>();
    }

    @Override
    public final Liquid getLiquidType(){
        return liquidTypeProperty().get();
    }

    @Override
    public final void setLiquidType(Liquid liquidType){
        this.liquidTypeProperty().set(liquidType);
    }

    @Override
    public final ObjectProperty<Liquid> liquidTypeProperty(){
        if(liquidType == null){
            liquidType = new SimpleObjectProperty<>(this, "liquidType", DEFAULT_LIQUID);
            liquidType.addListener(event -> refillParts());
        }
        return this.liquidType;
    }

    protected final void setFillableParts(Fillable... fillableParts){
        this.fillableParts = Arrays.asList(fillableParts);
        refillParts();
    }

    private void refillParts(){
        fillableParts.forEach(part -> part.fill(this.getLiquidType().color()));
    }
}