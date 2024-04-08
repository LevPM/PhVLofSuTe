package ru.riddle.model.menu;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.riddle.model.ModelUtil;

import java.io.IOException;

public class MainModel {

    public void backToMenuScreen(ActionEvent event){
        Parent root = null;
        try{
            root = FXMLLoader.load(getClass().getResource("/view/MenuScreenFXML.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ModelUtil.changeScreen(event, root);
    }

    public void openTheory(ActionEvent event){
        Parent root = null;
        try{
            root = FXMLLoader.load(getClass().getResource("/view/theory/TheoryFirstFXML.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        root.setId("First");

        ModelUtil.changeScreen(event, root);
    }
}
