package ru.riddle.model.menu;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import ru.riddle.model.util.FXMLs;
import ru.riddle.model.util.ModelUtil;

public class MainModel {

    public void backToMenuScreen(ActionEvent event){
        ModelUtil.changeScreen(event, FXMLs.MENU_SCREEN);
    }

    public void openTheory(ActionEvent event){
        ModelUtil.changeScreen(event, FXMLs.THEORY_FIRST);
    }
}
