package ru.riddle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MainScreenFXML.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
        } catch (IOException e){
            e.printStackTrace();
        }

        primaryStage.setTitle("PhSofSuTe");

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
