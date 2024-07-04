package ru.riddle.phVLofSuTe.model.experiments;

import javafx.event.ActionEvent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

import java.util.Arrays;
import java.util.List;

public class ThirdExperimentModel {

    public ThirdExperimentModel(){
    }

    public void leaveExperiment(ActionEvent event){
        ModelUtil.changeScreen(event, FXMLs.EXPERIMENTS_MENU);
    }

    public Callback<ListView<Liquid>, ListCell<Liquid>> getLiquidCellFactory(){
        return null;
    }

    public List<Liquid> getListOfLiquids(){
        return Arrays.asList(Liquid.values());
    }
}
