package ru.riddle.phVLofSuTe.model.experiments;

import javafx.collections.ObservableList;
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

    public Callback<ListView<TypesOfLiquids>, ListCell<TypesOfLiquids>> getLiquidCellFactory(){
        Callback<ListView<TypesOfLiquids>, ListCell<TypesOfLiquids>> liquidCellFactory = (lv) ->
                new ListCell<>() { //lv - listView
                    @Override
                    protected void updateItem(TypesOfLiquids item, boolean empty){
                        super.updateItem(item, empty);
                        if(empty){
                            setText("");
                        } else {
                           setText(item.getName());

                        }
                    }
                };
        return null;
    }

    public ObservableList<TypesOfLiquids> getListOfLiquids(){
        List<TypesOfLiquids> listOfLiquids = Arrays.asList(TypesOfLiquids.values());

        return null;
    }
}
