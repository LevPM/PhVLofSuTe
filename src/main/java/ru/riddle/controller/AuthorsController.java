package ru.riddle.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import ru.riddle.model.SettingsScreenModel;

public class AuthorsController {

    private final SettingsScreenModel model;

    @FXML
    private ListView listView;

    public AuthorsController(){
        model = new SettingsScreenModel();
    }
    public void handleBackButtonAction(ActionEvent event){
        model.openMainScreen(event);
    }
}
