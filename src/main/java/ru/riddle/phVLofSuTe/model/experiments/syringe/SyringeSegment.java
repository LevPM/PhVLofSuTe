package ru.riddle.phVLofSuTe.model.experiments.syringe;

import javafx.scene.Group;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

public class SyringeSegment extends Group {

    private static final int HEIGHT = 50;

    public SyringeSegment(int sequenceNumber){
        ModelUtil.downloadCustomComponentFXML(FXMLs.SYRINGE_SEGMENT, this);
        this.setLayoutY(-sequenceNumber * HEIGHT);
    }
}
