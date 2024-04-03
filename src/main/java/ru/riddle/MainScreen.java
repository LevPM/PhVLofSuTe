package ru.riddle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainScreen extends Application {

    @Override
    public void start(Stage primaryStage){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/MainScreenFXML.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            primaryStage.setScene(scene);

            MainController controller = loader.getController();

            primaryStage.setTitle("PhSofSuTe");

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
