package ru.riddle.phVLofSuTe.model.experiments.syringe;

import javafx.scene.Group;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

public class SyringeBodySegment extends Group {

    private static final int HEIGHT = 50;

    public SyringeBodySegment(int sequenceNumber){
        ModelUtil.downloadCustomComponentFXML(FXMLs.SYRINGE_SEGMENT, this);
        this.setLayoutY(-sequenceNumber * HEIGHT);
    }
}
