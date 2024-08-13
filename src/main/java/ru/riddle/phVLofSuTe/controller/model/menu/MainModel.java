package ru.riddle.phVLofSuTe.controller.model.menu;

import javafx.event.ActionEvent;
import ru.riddle.phVLofSuTe.controller.model.util.FXMLs;
import ru.riddle.phVLofSuTe.controller.model.util.ModelUtil;

public class MainModel {

    public void backToMenuScreen(ActionEvent event){
        ModelUtil.changeScreen(event, FXMLs.MENU_SCREEN);
    }

    public void openTheory(ActionEvent event){
        ModelUtil.changeScreen(event, FXMLs.THEORY_SELECTION);
    }

    public void openExperiments(ActionEvent event){
        ModelUtil.changeScreen(event, FXMLs.EXPERIMENTS_MENU);
    }
}
