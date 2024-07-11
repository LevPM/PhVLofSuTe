package ru.riddle.phVLofSuTe.model.customComponents.syringe.syringeLiquid;

import javafx.fxml.FXML;
import javafx.scene.Group;import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import ru.riddle.phVLofSuTe.model.customComponents.Fillable;
import ru.riddle.phVLofSuTe.model.experiments.Liquid;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

public class SyringeLiquidTip extends Group implements Fillable {

    private final Liquid liquidType;

    @FXML
    private Polygon liquid;

    public SyringeLiquidTip(Liquid liquidType){
        this.liquidType = liquidType;
        ModelUtil.downloadCustomComponentFXML(FXMLs.SYRINGE_LIQUID_TIP, this);
        this.liquid.setFill(liquidType.getColor());
    }

    @Override
    public void fill(Color color) {
        liquid.setFill(color);
    }
}
