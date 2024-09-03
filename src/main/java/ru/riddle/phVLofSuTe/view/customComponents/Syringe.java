package ru.riddle.phVLofSuTe.view.customComponents;

import de.saxsys.mvvmfx.FxmlPath;
import javafx.beans.property.IntegerProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.InjectViewModel;
import ru.riddle.phVLofSuTe.view.customComponents.properties.Segmentable;
import ru.riddle.phVLofSuTe.viewModel.customComponents.SyringeViewModel;

@FxmlPath("ru.riddle.phVLoSuTe.view.customComponents.syringe.fxml")
public class Syringe extends BorderedLiquidTankView<SyringeViewModel> implements Segmentable {

    private static final Logger logger = LoggerFactory.getLogger(Syringe.class);

    @InjectViewModel
    private SyringeViewModel viewModel;


    @Override
    public int getCountOfSegments() {
        return viewModel.countOfSegmentsProperty().get();
    }

    @Override
    public void setCountOfSegments(int countOfSegments) {
        viewModel.countOfSegmentsProperty().set(countOfSegments);
    }

    @Override
    public IntegerProperty countOfSegmentsProperty() {
        return viewModel.countOfSegmentsProperty();
    }


}