package ru.riddle.model.theory;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import ru.riddle.model.util.FXMLs;
import ru.riddle.model.util.ModelUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TheoryExamplesModel {

    private final List<FXMLs> firstExample = new ArrayList<>();
    {
        firstExample.addAll(Arrays.asList(
                FXMLs.THEORY_FIRST_EXAMPLE_1,
                FXMLs.THEORY_FIRST_EXAMPLE_2,
                FXMLs.THEORY_FIRST_EXAMPLE_3,
                FXMLs.THEORY_FIRST_EXAMPLE_4
        ));
    }

    public void backToPreviousScreen(ActionEvent event) {
        String id = ((Node) event.getSource()).getScene().getRoot().getId();

        ModelUtil.changeScreen(event,
                ModelUtil.downloadRoot(
                        switch (id.substring(0, id.length() - 1)){
                            case "FirstExample" -> firstExample.get(Integer.parseInt(id.substring(id.length() - 1)) - 2);
                            case "SecondExample" -> FXMLs.THEORY_FIRST_EXAMPLE_2;
                            default -> throw new IllegalStateException("Unexpected value: " + id);
                        }
                        ));
    }

    public void goToNextScreen(ActionEvent event) {
        String id = ((Node) event.getSource()).getScene().getRoot().getId();

        ModelUtil.changeScreen(event,
                ModelUtil.downloadRoot(
                        switch (id.substring(0, id.length() - 1)){
                            case "FirstExample" -> firstExample.get(Integer.parseInt(id.substring(id.length() - 1)));
                            case "SecondExample" -> FXMLs.THEORY_FIRST_EXAMPLE_2;
                            default -> throw new IllegalStateException("Unexpected value: " + id);
                        }
                        ));
    }

    public void backToExamplesMenu(ActionEvent event){
        Parent root = ModelUtil.downloadRoot(FXMLs.THEORY_EXAMPLES_MENU);
        ModelUtil.changeScreen(event, root);
    }
}
