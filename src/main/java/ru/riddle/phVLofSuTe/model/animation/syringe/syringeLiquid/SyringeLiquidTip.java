package ru.riddle.phVLofSuTe.model.animation.syringe.syringeLiquid;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.shape.Polygon;
import ru.riddle.phVLofSuTe.model.experiments.Liquid;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

public class SyringeLiquidTip extends Group {

    private final Liquid liquidType;

    @FXML
    private Polygon liquid;

    public SyringeLiquidTip(Liquid liquidType){
        this.liquidType = liquidType;
        ModelUtil.downloadCustomComponentFXML(FXMLs.SYRINGE_LIQUID_TIP, this);
        this.liquid.setFill(liquidType.getColor());
    }
}
