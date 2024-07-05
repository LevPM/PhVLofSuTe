package ru.riddle.phVLofSuTe.model.experiments.syringe;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.shape.Polygon;
import ru.riddle.phVLofSuTe.model.experiments.Liquid;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

public class LiquidContainer extends Group {

    private Liquid liquidType;

    @FXML
    private Polygon liquid;

    public LiquidContainer(Liquid liquidType){
        ModelUtil.downloadCustomComponentFXML(FXMLs.LIQUID_CONTAINER, this);
        this.liquidType = liquidType;
        liquid.setFill(liquidType.getColor());
    }
}
