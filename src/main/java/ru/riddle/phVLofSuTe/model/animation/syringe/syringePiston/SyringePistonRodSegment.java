package ru.riddle.phVLofSuTe.model.animation.syringe.syringePiston;

import javafx.scene.Group;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

public class SyringePistonRodSegment extends Group {

    public SyringePistonRodSegment(int sequenceNumber, int segmentHeight){
        ModelUtil.downloadCustomComponentFXML(FXMLs.SYRINGE_PISTON_SEGMENT, this);
        this.setLayoutY(-sequenceNumber * segmentHeight);
    }
}
