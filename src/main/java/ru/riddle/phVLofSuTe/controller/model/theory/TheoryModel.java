package ru.riddle.phVLofSuTe.controller.model.theory;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import ru.riddle.phVLofSuTe.model.FXMLs;
import ru.riddle.phVLofSuTe.model.ModelUtil;

@Deprecated
public class TheoryModel{


    public void backToPreviousScreen(ActionEvent event) {
        String id = ((Node) event.getSource()).getScene().getRoot().getId();

        ModelUtil.changeScreen(event,
                switch (id){
                        case "Second" -> FXMLs.THEORY_FIRST;
                        case "Third" -> FXMLs.THEORY_SECOND;
                        default -> throw new IllegalStateException("Unexpected value: " + id);
        }
        );
    }

    public void goToNextScreen(ActionEvent event) {
        String id = ((Node) event.getSource()).getScene().getRoot().getId();

        ModelUtil.changeScreen(event,
                switch (id) {
                    case "First" -> FXMLs.THEORY_SECOND;
                    case "Second" -> FXMLs.THEORY_THIRD;
                    default -> throw new IllegalStateException("Unexpected value: " + id);
        });

    }

    public void openExample(ActionEvent event){
        String id = ((Node) (event.getSource())).getId();
        ModelUtil.changeScreen(event,
                switch (id){
                        case "FirstExample" -> FXMLs.firstExample.getFirst();
                        case "SecondExample" -> FXMLs.secondExample.getFirst();
                        case "ThirdExample" -> FXMLs.thirdExample.getFirst();
                        case "FourthExample" -> FXMLs.fourthExample.getFirst();
                        case "FifthExample" -> FXMLs.fifthExample.getFirst();
                        case "SixthExample" -> FXMLs.sixthExample.getFirst();
                        default -> throw new IllegalStateException("Unexpected value: " + id);
        }
        );
    }

    public void openExamplesMenuScreen(ActionEvent event){
        ModelUtil.changeScreen(event, FXMLs.THEORY_EXAMPLES_MENU);
    }

    public void openTheory(ActionEvent event){
        ModelUtil.changeScreen(event, FXMLs.THEORY_FIRST);
    }

    public void backToTheoryExperimentsMenuScreen(ActionEvent event) {
        ModelUtil.changeScreen(event, FXMLs.MENU_TE_SELECTION);
    }

    public void leaveTheory(ActionEvent event) {
        ModelUtil.changeScreen(event, FXMLs.THEORY_SELECTION);
    }
}
