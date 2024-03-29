package ru.riddle;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainScreen extends Application {

    private Parent createContent() {

        Label l = new Label("Hello, JavaFX");

        return new StackPane(l);
    }

    @Override
    public void start(Stage stage){
        Scene scene = new Scene(createContent(), 640, 480);

        stage.setTitle("Physics Simulator of Surface Tension");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
