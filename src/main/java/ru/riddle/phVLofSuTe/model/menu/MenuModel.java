package ru.riddle.phVLofSuTe.model.menu;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

public class MenuModel {

    public void openSettingsScreen(ActionEvent event){
        ModelUtil.changeScreen(event, FXMLs.SETTINGS_SCREEN);
    }

    public void openAuthorsScreen(ActionEvent event){
        ModelUtil.changeScreen(event, FXMLs.AUTHORS_SCREEN);
    }

    public void backToMenuScreen(ActionEvent event){
        ModelUtil.changeScreen(event, FXMLs.MENU_SCREEN);
    }

    public void closeApp(){
        Platform.exit();
        System.exit(0);
    }

    public void openMenuTESelectionScreen(ActionEvent event){
        ModelUtil.changeScreen(event, FXMLs.MENU_TE_SELECTION);
    }
}
