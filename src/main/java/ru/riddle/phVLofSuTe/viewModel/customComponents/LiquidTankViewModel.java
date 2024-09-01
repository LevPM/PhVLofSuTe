package ru.riddle.phVLofSuTe.viewModel.customComponents;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.ViewModel;
import ru.riddle.phVLofSuTe.controller.model.customComponents.Fillable;
import ru.riddle.phVLofSuTe.viewModel.customComponents.properties.LiquidTypeable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LiquidTankViewModel implements ViewModel, LiquidTypeable {

    private static final Logger logger = LoggerFactory.getLogger(LiquidTankViewModel.class);

    private static final LiquidL DEFAULT_LIQUID = LiquidL.WATER;

    private ObjectProperty<LiquidL> liquidType;

    private List<Fillable> fillableParts;

    public LiquidTankViewModel() {
        fillableParts = new ArrayList<>();
    }

    @Override
    public final LiquidL getLiquidType(){
        return liquidTypeProperty().get();
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

    protected void setFillableParts(Fillable... fillableParts){
        this.fillableParts = Arrays.asList(fillableParts);
        fillParts();
    }

    private void fillParts(){
        fillableParts.forEach(part -> part.fill(this.getLiquidType().getColor()));
    }
}