package ru.riddle.PhVLofSuTe.model.experiments;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import ru.riddle.PhVLofSuTe.model.util.FXMLs;
import ru.riddle.PhVLofSuTe.model.util.ModelUtil;

public class ExperimentsModel {

    public void leaveExperiments(ActionEvent event){
        ModelUtil.changeScreen(event, FXMLs.MENU_TE_SELECTION);
    }

    public void openExperiment(ActionEvent event){
        String id = ((Node) (event.getSource())).getId();
        ModelUtil.changeScreen(event,
                switch (id){
                    case "FirstExperiment" -> FXMLs.firstExample.getFirst();
                    case "SecondExperiment" -> FXMLs.secondExample.getFirst();
                    case "ThirdExperiment" -> FXMLs.thirdExample.getFirst();
                    case "FourthExperiment" -> FXMLs.fourthExample.getFirst();
                    default -> throw new IllegalStateException("Unexpected value: " + id);
                }
        );
    }
}
