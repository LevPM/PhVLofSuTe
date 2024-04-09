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
                root.setId("First");

                ModelUtil.changeScreen(event, root);
            }
        }
    }

    public void goToNextScreen(ActionEvent event) {
        String id = ((Node) event.getSource()).getScene().getRoot().getId();

        ModelUtil.changeScreen(event,
        switch (id){
            case "First" -> {
                Parent root = ModelUtil.downloadRoot(FXMLs.THEORY_SECOND);
                root.setId("Second");
                yield root;
            }
            case "Second" -> {
                Parent root = ModelUtil.downloadRoot(FXMLs.THEORY_SECOND);
                root.setId("Third");
                yield root;
            }
            default -> throw new IllegalStateException("Unexpected value: " + id);
        }
        );

    }

    public void leaveTheory(ActionEvent event) {
        Parent root = ModelUtil.downloadRoot(FXMLs.MENU_FORMULAS_SCREEN);

        ModelUtil.changeScreen(event, root);
    }
}
