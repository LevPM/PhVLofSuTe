package ru.riddle.PhVLofSuTe.model.theory;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import ru.riddle.PhVLofSuTe.model.util.FXMLs;
import ru.riddle.PhVLofSuTe.model.util.ModelUtil;

public class TheoryModel{


    public void backToPreviousScreen(ActionEvent event) {
        String id = ((Node) event.getSource()).getScene().getRoot().getId();

        ModelUtil.changeScreen(event,
                switch (id){
                        case "Second" -> FXMLs.THEORY_FIRST;
                        case "Third" -> FXMLs.THEORY_SECOND;
                        case "ExamplesMenu" -> FXMLs.THEORY_THIRD;
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
                    case "Third" -> FXMLs.THEORY_EXAMPLES_MENU;
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

    public void leaveTheory(ActionEvent event) {
        ModelUtil.changeScreen(event, FXMLs.MENU_FORMULAS_SCREEN);
    }
}
