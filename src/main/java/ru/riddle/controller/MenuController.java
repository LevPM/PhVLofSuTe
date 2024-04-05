package ru.riddle.controller;

import javafx.event.ActionEvent;
import ru.riddle.model.menu.MenuModel;
public class MenuController {

    private final MenuModel model;

    public MenuController(){
        model = new MenuModel();
    }

    public void handleSettingButtonAction(ActionEvent event){
        model.openSettingsScreen(event);
    }

    public void handleAuthorsButtonAction(ActionEvent event){
        model.openAuthorsScreen(event);
    }

    public void handleBackButtonAction(ActionEvent event){
        model.backToMenuScreen(event);
    }

    public void handleCloseButtonAction(){
        model.closeApp();
    }

    public void handleStartButtonAction(ActionEvent event) {
        model.openMenuFormulasScreen(event);
    }
}
