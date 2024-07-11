package ru.riddle.phVLofSuTe.model.customComponents.syringe.syringeBody;

import javafx.scene.Group;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

public class SyringeBodyStub extends Group {

    public SyringeBodyStub(int bodyHeight){
        ModelUtil.downloadCustomComponentFXML(FXMLs.SYRINGE_BODY_STUB, this);
        this.setLayoutY(-bodyHeight + 0.5);
    }
}
