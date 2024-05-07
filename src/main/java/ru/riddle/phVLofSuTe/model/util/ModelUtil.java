package ru.riddle.phVLofSuTe.model.util;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ModelUtil {

    public static void changeScreen(ActionEvent event, FXMLs fxml){
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        double height = stage.getHeight();
        double width = stage.getWidth();
        boolean isFullScreen = stage.isFullScreen();
        Scene scene = new Scene(downloadRoot(fxml));
        stage.setScene(scene);
        stage.setHeight(height);
        stage.setWidth(width);
        stage.setFullScreen(isFullScreen);
        stage.show();
    }

    public static Parent downloadRoot(FXMLs fxml){
        Parent root = null;

        try {
            root = FXMLLoader.load(ModelUtil.class.getResource(fxml.getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(fxml.getId() != null){
            root.setId(fxml.getId());
        }

        return root;
    }
}