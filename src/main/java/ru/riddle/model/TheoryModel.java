package ru.riddle.model;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import ru.riddle.model.util.FXMLs;
import ru.riddle.model.util.ModelUtil;

public class TheoryModel{


    public void backToPreviousScreen(ActionEvent event) {
        String id = ((Node) event.getSource()).getScene().getRoot().getId();

        switch (id){
            case "Second" -> {
                Parent root = ModelUtil.downloadRoot(FXMLs.THEORY_FIRST);
                ModelUtil.changeScreen(event, root);
            }
            case "Third" -> {
                Parent root = ModelUtil.downloadRoot(FXMLs.THEORY_SECOND);
                ModelUtil.changeScreen(event, root);
            }
            case "Fourth" -> {
                Parent root = ModelUtil.downloadRoot(FXMLs.THEORY_THIRD);
                ModelUtil.changeScreen(event, root);
            }
            case "Fifth" -> {
                Parent root = ModelUtil.downloadRoot(FXMLs.THEORY_FOURTH);
                ModelUtil.changeScreen(event, root);
            }
        }
    }

    public void goToNextScreen(ActionEvent event) {
        String id = ((Node) event.getSource()).getScene().getRoot().getId();

        ModelUtil.changeScreen(event,
        switch (id){
            case "First" -> ModelUtil.downloadRoot(FXMLs.THEORY_SECOND);
            case "Second" -> ModelUtil.downloadRoot(FXMLs.THEORY_THIRD);
            case "Third" -> ModelUtil.downloadRoot(FXMLs.THEORY_FOURTH);
            case "Fourth" -> ModelUtil.downloadRoot(FXMLs.THEORY_FIFTH);
            default -> throw new IllegalStateException("Unexpected value: " + id);
        }
        );

    }

    public void leaveTheory(ActionEvent event) {
        Parent root = ModelUtil.downloadRoot(FXMLs.MENU_FORMULAS_SCREEN);
        ModelUtil.changeScreen(event, root);
    }
}
