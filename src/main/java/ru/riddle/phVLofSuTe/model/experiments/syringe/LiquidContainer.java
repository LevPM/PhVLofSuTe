package ru.riddle.phVLofSuTe.model.experiments.syringe;

import javafx.scene.Group;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

public class LiquidContainer extends Group {

    public LiquidContainer(){
        ModelUtil.downloadCustomComponentFXML(FXMLs.LIQUID_CONTAINER, this);
    }
}
