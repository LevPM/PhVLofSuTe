package ru.riddle.phVLofSuTe.model.experiments.syringe;

import javafx.scene.Group;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

public class Drop extends Group {

    public Drop(){
        ModelUtil.downloadCustomComponentFXML(FXMLs.DROP, this);
    }
}
