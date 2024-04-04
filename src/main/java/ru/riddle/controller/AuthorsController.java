package ru.riddle.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import ru.riddle.model.AuthorsScreenModel;

public class AuthorsController {

    private final AuthorsScreenModel model;

    @FXML
    private ListView listView;

    public AuthorsController(){
        model = new AuthorsScreenModel();
    }
    public void handleBackButtonAction(ActionEvent event){
        model.openMainScreen(event);
    }
}
