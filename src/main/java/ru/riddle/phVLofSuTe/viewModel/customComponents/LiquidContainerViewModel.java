package ru.riddle.phVLofSuTe.viewModel.customComponents;

import de.saxsys.mvvmfx.Initialize;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LiquidContainerViewModel extends BorderedLiquidTankViewModel implements Fillable{

    private static final Logger logger = LoggerFactory.getLogger(LiquidContainerViewModel.class);

    private final ObjectProperty<Color> liquidColor = new SimpleObjectProperty<>();

    @Override
    public void fill(Color color) {
        liquidColor.set(color);
    }

    @Initialize
    private void initialize(){
        this.setFillableParts(this);
    }

    public ObjectProperty<Color> liquidColorProperty() {
        return liquidColor;
    }
}