package ru.riddle.phVLofSuTe.view.customComponents;

import javafx.beans.property.ObjectProperty;
import javafx.scene.Group;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import ru.riddle.phVLofSuTe.model.data.json.liquid.Liquid;
import ru.riddle.phVLofSuTe.viewModel.customComponents.LiquidTankViewModel;
import ru.riddle.phVLofSuTe.view.customComponents.properties.LiquidTypeable;

public abstract class LiquidTankView<T extends LiquidTankViewModel> extends Group implements FxmlView<LiquidTankViewModel>, LiquidTypeable {

    private static final Logger logger = LoggerFactory.getLogger(LiquidTankView.class);

    @InjectViewModel
    private T viewModel;

    @Override
    public Liquid getLiquidType() {
        return viewModel.liquidTypeProperty().get();
    }

    @Override
    public void setLiquidType(Liquid liquidType) {
        viewModel.liquidTypeProperty().set(liquidType);
    }

    @Override
    public ObjectProperty<Liquid> liquidTypeProperty() {
        return viewModel.liquidTypeProperty();
    }
}