package ru.riddle.controller;

import javafx.event.ActionEvent;
import ru.riddle.model.MainScreenModel;
public class MainController{

    private final MainScreenModel model;

    public MainController(){
        model = new MainScreenModel();
    }

    public void handleSettingButtonAction(ActionEvent event){
        model.openSettingsScreen(event);
    }

    public void handleAuthorsButtonAction(ActionEvent event){
        model.openAuthorsScreen(event);
    }

    public void handleCloseButtonAction(){
        model.closeApp();
    }
}
