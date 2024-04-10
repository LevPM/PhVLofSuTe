package ru.riddle.model.theory;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import ru.riddle.model.util.FXMLs;
import ru.riddle.model.util.ModelUtil;

public class TheoryModel{


    public void backToPreviousScreen(ActionEvent event) {
        String id = ((Node) event.getSource()).getScene().getRoot().getId();

        ModelUtil.changeScreen(event,
                ModelUtil.downloadRoot(
                    switch (id){
                        case "Second" -> FXMLs.THEORY_FIRST;
                        case "Third" -> FXMLs.THEORY_SECOND;
                        case "ExamplesMenu" -> FXMLs.THEORY_THIRD;
                        default -> throw new IllegalStateException("Unexpected value: " + id);
                    }
                    ));
        }

    public void goToNextScreen(ActionEvent event) {
        String id = ((Node) event.getSource()).getScene().getRoot().getId();

        ModelUtil.changeScreen(event,
                ModelUtil.downloadRoot(
                    switch (id) {
                        case "First" -> FXMLs.THEORY_SECOND;
                        case "Second" -> FXMLs.THEORY_THIRD;
                        case "Third" -> FXMLs.THEORY_EXAMPLES_MENU;
                        default -> throw new IllegalStateException("Unexpected value: " + id);
                    }));

    }

    public void leaveTheory(ActionEvent event) {
        Parent root = ModelUtil.downloadRoot(FXMLs.MENU_FORMULAS_SCREEN);
        ModelUtil.changeScreen(event, root);
    }
}
