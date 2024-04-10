package ru.riddle.model.theory;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import ru.riddle.model.util.FXMLs;
import ru.riddle.model.util.ModelUtil;

public class TheoryExamplesModel {

    public void backToPreviousScreen(ActionEvent event) {
        String id = ((Node) event.getSource()).getScene().getRoot().getId();

        ModelUtil.changeScreen(event,
                switch (id){
                    case "SecondExample" -> ModelUtil.downloadRoot(FXMLs.THEORY_FIRST_EXAMPLE_1);
                    case "ThirdExample" -> ModelUtil.downloadRoot(FXMLs.THEORY_FIRST_EXAMPLE_2);
                    case "FourthExample" -> ModelUtil.downloadRoot(FXMLs.THEORY_FIRST_EXAMPLE_3);
                    default -> throw new IllegalStateException("Unexpected value: " + id);
                });
    }

    public void goToNextScreen(ActionEvent event) {
        String id = ((Node) event.getSource()).getScene().getRoot().getId();

        ModelUtil.changeScreen(event,
                switch (id){
                    case "FirstExample" -> ModelUtil.downloadRoot(FXMLs.THEORY_FIRST_EXAMPLE_2);
                    case "SecondExample" -> ModelUtil.downloadRoot(FXMLs.THEORY_FIRST_EXAMPLE_3);
                    case "ThirdExample" -> ModelUtil.downloadRoot(FXMLs.THEORY_FIRST_EXAMPLE_4);
                    default -> throw new IllegalStateException("Unexpected value: " + id);
                }
        );

    }

    public void leaveExample(ActionEvent event){
        Parent root = ModelUtil.downloadRoot(FXMLs.THEORY_EXAMPLES_MENU);
        ModelUtil.changeScreen(event, root);
    }
}
