package ru.riddle.phVLofSuTe.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import ru.riddle.phVLofSuTe.controller.model.menu.MenuModel;
import ru.riddle.phVLofSuTe.controller.model.util.AppProperties;
import ru.riddle.phVLofSuTe.controller.model.util.FXMLs;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @FXML
    private Label versionLabel;

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
        model.openMenuTESelectionScreen(event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(url.getPath().endsWith(FXMLs.MENU_SCREEN.getPath())) {
            versionLabel.setText(AppProperties.getAppVersion());
        }
    }
}
