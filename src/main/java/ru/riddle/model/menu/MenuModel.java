package ru.riddle.model.menu;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuModel {

    public void openSettingsScreen(ActionEvent event){
        Parent root = null;
        try{
            root = FXMLLoader.load(getClass().getResource("/view/SettingsScreenFXML.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        double height = stage.getHeight();
        double width = stage.getWidth();
        boolean isFullScreen = stage.isFullScreen();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setHeight(height);
        stage.setWidth(width);
        stage.setFullScreen(isFullScreen);
        stage.show();
    }

    public void openAuthorsScreen(ActionEvent event){
        Parent root = null;
        try{
            root = FXMLLoader.load(getClass().getResource("/view/AuthorsScreenFXML.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        double height = stage.getHeight();
        double width = stage.getWidth();
        boolean isFullScreen = stage.isFullScreen();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setHeight(height);
        stage.setWidth(width);
        stage.setFullScreen(isFullScreen);
        stage.show();
    }

    public void backToMenuScreen(ActionEvent event){
        Parent root = null;
        try{
            root = FXMLLoader.load(getClass().getResource("/view/MenuScreenFXML.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        double height = stage.getHeight();
        double width = stage.getWidth();
        boolean isFullScreen = stage.isFullScreen();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setHeight(height);
        stage.setWidth(width);
        stage.setFullScreen(isFullScreen);
        stage.show();
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

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        double height = stage.getHeight();
        double width = stage.getWidth();
        boolean isFullScreen = stage.isFullScreen();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setScene(scene);
        stage.setHeight(height);
        stage.setWidth(width);
        stage.setFullScreen(isFullScreen);
        stage.show();
    }
}
