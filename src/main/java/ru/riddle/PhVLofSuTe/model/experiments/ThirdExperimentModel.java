package ru.riddle.PhVLofSuTe.model.experiments;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import ru.riddle.PhVLofSuTe.model.util.FXMLs;
import ru.riddle.PhVLofSuTe.model.util.ModelUtil;

public class ThirdExperimentModel {

    public ThirdExperimentModel(AnchorPane thirdExperimentSyringe){
    }

    public void leaveExperiment(ActionEvent event){
        ModelUtil.changeScreen(event, FXMLs.EXPERIMENTS_MENU);
    }
}
