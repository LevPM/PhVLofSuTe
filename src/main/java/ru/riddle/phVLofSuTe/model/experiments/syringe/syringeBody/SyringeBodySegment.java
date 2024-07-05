package ru.riddle.phVLofSuTe.model.experiments.syringe.syringeBody;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import ru.riddle.phVLofSuTe.model.experiments.Liquid;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

public class SyringeBodySegment extends Group{

    private final Liquid liquidType;

    @FXML
    private Rectangle liquid;

    public SyringeBodySegment(int sequenceNumber, int segmentHeight, Liquid liquidType){
        ModelUtil.downloadCustomComponentFXML(FXMLs.SYRINGE_BODY_SEGMENT, this);
        this.setLayoutY(-sequenceNumber * segmentHeight);
        this.liquidType = liquidType;
        liquid.setFill(this.liquidType.getColor());
        liquid.setVisible(false);
    }
}
