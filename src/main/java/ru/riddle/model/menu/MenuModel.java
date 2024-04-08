package ru.riddle.model.menu;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.riddle.model.ModelUtil;

import java.io.IOException;

public class MenuModel {

    public void openSettingsScreen(ActionEvent event){
        Parent root = null;
        try{
            root = FXMLLoader.load(getClass().getResource("/view/SettingsScreenFXML.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ModelUtil.changeScreen(event, root);
    }

    public void openAuthorsScreen(ActionEvent event){
        Parent root = null;
        try{
            root = FXMLLoader.load(getClass().getResource("/view/AuthorsScreenFXML.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ModelUtil.changeScreen(event, root);
    }

    public void backToMenuScreen(ActionEvent event){
        Parent root = null;
        try{
            root = FXMLLoader.load(getClass().getResource("/view/MenuScreenFXML.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ModelUtil.changeScreen(event, root);
    }

    public void closeApp(){
        Platform.exit();
        System.exit(0);
    }

    public void openMenuFormulasScreen(ActionEvent event){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/view/MenuFormulasScreenFXML.fxml"));
        } catch (IOException e){
            e.printStackTrace();
        }

        ModelUtil.changeScreen(event, root);
    }
}
