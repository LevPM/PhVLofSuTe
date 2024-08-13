package ru.riddle.phVLofSuTe.controller.model.experiments.thirdExperiment;

import javafx.event.ActionEvent;
import ru.riddle.phVLofSuTe.controller.model.util.FXMLs;
import ru.riddle.phVLofSuTe.controller.model.util.ModelUtil;

public class ThirdExperimentModel {

    public ThirdExperimentModel(){
    }

    public void leaveExperiment(ActionEvent event){
        ModelUtil.changeScreen(event, FXMLs.EXPERIMENTS_MENU);
    }
}
