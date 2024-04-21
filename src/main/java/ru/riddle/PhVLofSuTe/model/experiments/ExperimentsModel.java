package ru.riddle.PhVLofSuTe.model.experiments;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
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
                    case "FirstExperiment" -> FXMLs.EXPERIMENTS_FIRST;
                    case "SecondExperiment" -> FXMLs.secondExample.getFirst();
                    case "ThirdExperiment" -> FXMLs.thirdExample.getFirst();
                    case "FourthExperiment" -> FXMLs.fourthExample.getFirst();
                    default -> throw new IllegalStateException("Unexpected value: " + id);
                }
        );
    }

    public void startFirstExperiment(ActionEvent event, ImageView syringePiston){
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(syringePiston);
        translate.setDuration(Duration.seconds(8));
        translate.setByY(194);
        translate.play();
    }
}
