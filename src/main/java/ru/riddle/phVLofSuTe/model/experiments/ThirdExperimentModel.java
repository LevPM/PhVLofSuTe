package ru.riddle.phVLofSuTe.model.experiments;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

public class ThirdExperimentModel {

    public ThirdExperimentModel(AnchorPane thirdExperimentSyringe){
    }

    public void leaveExperiment(ActionEvent event){
        ModelUtil.changeScreen(event, FXMLs.EXPERIMENTS_MENU);
    }
}
