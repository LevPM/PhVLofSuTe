package ru.riddle.controller;

import javafx.event.ActionEvent;
import ru.riddle.model.MenuScreenModel;
public class MenuController {

    private final MenuScreenModel model;

    public MenuController(){
        model = new MenuScreenModel();
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
