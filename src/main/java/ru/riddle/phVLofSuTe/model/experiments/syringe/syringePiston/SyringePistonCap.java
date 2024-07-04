package ru.riddle.phVLofSuTe.model.experiments.syringe.syringePiston;

import javafx.scene.Group;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

public class SyringePistonCap extends Group {

    public SyringePistonCap(int pistonHeight){
        ModelUtil.downloadCustomComponentFXML(FXMLs.SYRINGE_PISTON_CAP, this);
        this.setLayoutY(-pistonHeight);
    }
}
