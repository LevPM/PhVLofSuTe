package ru.riddle.PhSofSuTe.model.theory;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import ru.riddle.PhSofSuTe.model.util.FXMLs;
import ru.riddle.PhSofSuTe.model.util.ModelUtil;

public class TheoryExamplesModel {

    public void backToPreviousScreen(ActionEvent event) {
        String id = ((Node) event.getSource()).getScene().getRoot().getId();

        final int numberOfPreviousFXML = Integer.parseInt(id.substring(id.length() - 1)) - 2;
        ModelUtil.changeScreen(event,
                switch (id.substring(0, id.length() - 1)){
                        case "FirstExample" -> FXMLs.firstExample.get(numberOfPreviousFXML);
                        case "SecondExample" -> FXMLs.secondExample.get(numberOfPreviousFXML);
                        case "ThirdExample" -> FXMLs.thirdExample.get(numberOfPreviousFXML);
                        case "FourthExample" -> FXMLs.fourthExample.get(numberOfPreviousFXML);
                        case "FifthExample" -> FXMLs.fifthExample.get(numberOfPreviousFXML);
                        case "SixthExample" -> FXMLs.sixthExample.get(numberOfPreviousFXML);
                        default -> throw new IllegalStateException("Unexpected value: " + id);
        }
        );
    }

    public void goToNextScreen(ActionEvent event) {
        String id = ((Node) event.getSource()).getScene().getRoot().getId();

        final int numberOfNextFXML = Integer.parseInt(id.substring(id.length() - 1));
        ModelUtil.changeScreen(event,
                switch (id.substring(0, id.length() - 1)){
                        case "FirstExample" -> FXMLs.firstExample.get(numberOfNextFXML);
                        case "SecondExample" -> FXMLs.secondExample.get(numberOfNextFXML);
                        case "ThirdExample" -> FXMLs.thirdExample.get(numberOfNextFXML);
                        case "FourthExample" -> FXMLs.fourthExample.get(numberOfNextFXML);
                        case "FifthExample" -> FXMLs.fifthExample.get(numberOfNextFXML);
                        case "SixthExample" -> FXMLs.sixthExample.get(numberOfNextFXML);
                        default -> throw new IllegalStateException("Unexpected value: " + id);
        }
        );
    }

    public void backToExamplesMenu(ActionEvent event){
        ModelUtil.changeScreen(event, FXMLs.THEORY_EXAMPLES_MENU);
    }
}
