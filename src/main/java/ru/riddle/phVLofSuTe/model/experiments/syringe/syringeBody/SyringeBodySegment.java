package ru.riddle.phVLofSuTe.model.experiments.syringe.syringeBody;

import javafx.scene.Group;
import ru.riddle.phVLofSuTe.model.experiments.Liquid;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

public class SyringeBodySegment extends Group{

    public SyringeBodySegment(int sequenceNumber, int segmentHeight, Liquid liquidType){
        ModelUtil.downloadCustomComponentFXML(FXMLs.SYRINGE_BODY_SEGMENT, this);
        this.setLayoutY(-sequenceNumber * segmentHeight);
    }
}
