package ru.riddle.model.menu;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import ru.riddle.model.util.FXMLsPaths;
import ru.riddle.model.util.ModelUtil;

public class MenuModel {

    public void openSettingsScreen(ActionEvent event){
        Parent root = ModelUtil.downloadRoot(FXMLsPaths.SETTINGS_SCREEN);

        ModelUtil.changeScreen(event, root);
    }

    public void openAuthorsScreen(ActionEvent event){
        Parent root = ModelUtil.downloadRoot(FXMLsPaths.AUTHORS_SCREEN);

        ModelUtil.changeScreen(event, root);
    }

    public void backToMenuScreen(ActionEvent event){
        Parent root = ModelUtil.downloadRoot(FXMLsPaths.MENU_SCREEN);

        ModelUtil.changeScreen(event, root);
    }

    public void closeApp(){
        Platform.exit();
        System.exit(0);
    }

    public void openMenuFormulasScreen(ActionEvent event){
        Parent root = ModelUtil.downloadRoot(FXMLsPaths.MENU_FORMULAS_SCREEN);

        ModelUtil.changeScreen(event, root);
    }
}
