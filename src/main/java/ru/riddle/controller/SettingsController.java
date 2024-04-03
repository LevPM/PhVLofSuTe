package ru.riddle.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import ru.riddle.model.SettingsScreenModel;

public class SettingsController {

    private final SettingsScreenModel model;

    @FXML
    private ListView listView;

    public SettingsController(){
        model = new SettingsScreenModel();
    }
    public void handleBackButtonAction(ActionEvent event){
        model.openMainScreen(event);
    }
}
