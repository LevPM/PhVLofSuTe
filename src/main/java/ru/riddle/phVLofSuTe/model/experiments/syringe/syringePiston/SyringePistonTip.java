package ru.riddle.phVLofSuTe.model.experiments.syringe.syringePiston;

import javafx.scene.Group;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

public class SyringePistonTip extends Group {

    public SyringePistonTip(){
        ModelUtil.downloadCustomComponentFXML(FXMLs.SYRINGE_PISTON_TIP, this);
    }
}
