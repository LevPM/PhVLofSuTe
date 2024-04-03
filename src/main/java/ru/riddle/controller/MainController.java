package ru.riddle.controller;

import javafx.stage.Stage;
import ru.riddle.model.MainScreenModel;
public class MainController{

    private final MainScreenModel model;
    private Stage stage;

    public MainController(){
        model = new MainScreenModel();
    }

    public void handleSettingButtonAction(){
        model.openSettingsScreen();
    }
}
