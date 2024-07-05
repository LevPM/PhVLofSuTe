package ru.riddle.phVLofSuTe.model.experiments.syringe.syringeLiquid;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import ru.riddle.phVLofSuTe.model.experiments.Liquid;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

public class SyringeLiquidSegment extends Group{

    private final Liquid liquidType;

    @FXML
    private Rectangle liquid;

    public SyringeLiquidSegment(int sequenceNumber, int segmentHeight, Liquid liquidType) {
        ModelUtil.downloadCustomComponentFXML(FXMLs.SYRINGE_LIQUID_SEGMENT, this);
        this.setLayoutY(-sequenceNumber * segmentHeight);
        this.liquidType = liquidType;
        liquid.setFill(this.liquidType.getColor());
    }
}
