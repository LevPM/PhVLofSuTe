package ru.riddle.model.menu;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import ru.riddle.model.util.FXMLs;
import ru.riddle.model.util.ModelUtil;

public class MainModel {

    public void backToMenuScreen(ActionEvent event){
        Parent root = ModelUtil.downloadRoot(FXMLs.MENU_SCREEN);
        ModelUtil.changeScreen(event, root);
    }

    public void openTheory(ActionEvent event){
        Parent root = ModelUtil.downloadRoot(FXMLs.THEORY_FIRST);
        root.setId("First");

        ModelUtil.changeScreen(event, root);
    }
}
