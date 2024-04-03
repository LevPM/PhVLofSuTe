package ru.riddle.model;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainScreenModel {

    public void openSettingsScreen(ActionEvent event){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/view/SettingsScreenFXML.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openAuthorsScreen(ActionEvent event){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/view/AuthorsScreenFXML.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeApp(){
        Platform.exit();
        System.exit(0);
    }
}
