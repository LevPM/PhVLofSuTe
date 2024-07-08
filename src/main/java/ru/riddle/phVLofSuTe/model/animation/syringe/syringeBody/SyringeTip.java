package ru.riddle.phVLofSuTe.model.animation.syringe.syringeBody;

import javafx.scene.Group;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

public class SyringeTip extends Group {

    public SyringeTip(){
        ModelUtil.downloadCustomComponentFXML(FXMLs.SYRINGE_TIP, this);
    }
}
