package ru.riddle.PhVLofSuTe.model.menu;

import javafx.event.ActionEvent;
import ru.riddle.PhVLofSuTe.model.util.FXMLs;
import ru.riddle.PhVLofSuTe.model.util.ModelUtil;

public class MainModel {

    public void backToMenuScreen(ActionEvent event){
        ModelUtil.changeScreen(event, FXMLs.MENU_SCREEN);
    }

    public void openTheory(ActionEvent event){
        ModelUtil.changeScreen(event, FXMLs.THEORY_SELECTION);
    }
}
