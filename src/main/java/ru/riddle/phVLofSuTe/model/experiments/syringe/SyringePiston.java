package ru.riddle.phVLofSuTe.model.experiments.syringe;

import javafx.scene.Group;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

public class SyringePiston extends Group {

    private final int countOfSegments;

    public SyringePiston(int countOfSegments){
        ModelUtil.downloadCustomComponentFXML(FXMLs.SYRINGE_PISTON, this);
        this.countOfSegments = countOfSegments;
    }
}
