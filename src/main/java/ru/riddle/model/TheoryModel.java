package ru.riddle.model;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TheoryModel {

    public void leaveTheory(ActionEvent event){
        Parent root = null;
        try{
            root = FXMLLoader.load(getClass().getResource("/view/MenuFormulasScreenFXML.fxml"));
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
}
