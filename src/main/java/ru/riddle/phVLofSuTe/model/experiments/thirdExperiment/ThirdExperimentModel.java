package ru.riddle.phVLofSuTe.model.experiments.thirdExperiment;

import javafx.event.ActionEvent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import ru.riddle.phVLofSuTe.model.experiments.Liquid;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

public class ThirdExperimentModel {

    public ThirdExperimentModel(){
    }

    public void leaveExperiment(ActionEvent event){
        ModelUtil.changeScreen(event, FXMLs.EXPERIMENTS_MENU);
    }

    public Callback<ListView<Liquid>, ListCell<Liquid>> getLiquidCellFactory(){
        return null;
    }
}
