package ru.riddle.PhVLofSuTe;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.riddle.PhVLofSuTe.model.util.FXMLs;
import ru.riddle.PhVLofSuTe.model.util.ModelUtil;

public class PhVLofSuTe extends Application {

    @Override
    public void start(Stage primaryStage){
        Parent root = ModelUtil.downloadRoot(FXMLs.MENU_SCREEN);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("PhSofSuTe");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
