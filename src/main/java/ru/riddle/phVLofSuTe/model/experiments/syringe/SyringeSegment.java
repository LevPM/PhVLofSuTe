package ru.riddle.phVLofSuTe.model.experiments.syringe;

import javafx.scene.Group;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

public class SyringeSegment extends Group {

    public SyringeSegment(){
        ModelUtil.downloadCustomComponentFXML(FXMLs.SYRINGE_SEGMENT, this);
    }
}
