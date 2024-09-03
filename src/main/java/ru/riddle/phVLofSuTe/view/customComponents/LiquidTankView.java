package ru.riddle.phVLofSuTe.view.customComponents;

import javafx.scene.Group;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import ru.riddle.phVLofSuTe.viewModel.customComponents.LiquidTankViewModel;

public abstract class LiquidTankView<T extends LiquidTankViewModel> extends Group implements FxmlView<LiquidTankViewModel> {

    private static final Logger logger = LoggerFactory.getLogger(LiquidTankView.class);

    @InjectViewModel
    private T viewModel;


}