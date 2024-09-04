package ru.riddle.phVLofSuTe.viewModel.customComponents;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LiquidContainerViewModel extends BorderedLiquidTankViewModel{

    private static final Logger logger = LoggerFactory.getLogger(LiquidContainerViewModel.class);

    private final ObjectProperty<Color> liquidColor = new SimpleObjectProperty<>();

    public ObjectProperty<Color> liquidColorProperty() {
        return liquidColor;
    }
}