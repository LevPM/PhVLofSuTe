package ru.riddle.phVLofSuTe.viewModel.customComponents;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.ViewModel;
import ru.riddle.phVLofSuTe.model.data.json.liquid.Liquid;
import ru.riddle.phVLofSuTe.model.data.json.liquid.LiquidManager;
import ru.riddle.phVLofSuTe.view.customComponents.Fillable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LiquidTankViewModel implements ViewModel{

    private static final Logger logger = LoggerFactory.getLogger(LiquidTankViewModel.class);

    private static final Liquid DEFAULT_LIQUID = LiquidManager.getLiquid("Water");

    private ObjectProperty<Liquid> liquidType;

    public final ObjectProperty<Liquid> liquidTypeProperty(){
        if(liquidType == null){
            liquidType = new SimpleObjectProperty<>(this, "liquidType", DEFAULT_LIQUID);
        }
        return this.liquidType;
    }
}