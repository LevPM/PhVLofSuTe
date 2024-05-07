package ru.riddle.PhVLofSuTe.model.experiments;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Arc;
import ru.riddle.PhVLofSuTe.model.util.FXMLs;
import ru.riddle.PhVLofSuTe.model.util.ModelUtil;

public class ExperimentsModel {

    private final ExperimentsAnimationModel animationModel;

    public ExperimentsModel() {
        animationModel = new ExperimentsAnimationModel();
    }

    public void leaveExperiments(ActionEvent event){
        ModelUtil.changeScreen(event, FXMLs.MENU_TE_SELECTION);
    }

    public void leaveExperiment(ActionEvent event){
        ModelUtil.changeScreen(event, FXMLs.EXPERIMENTS_MENU);
    }

    public void openExperiment(ActionEvent event){
        String id = ((Node) (event.getSource())).getId();
        ModelUtil.changeScreen(event,
                switch (id){
                    case "FirstExperiment" -> FXMLs.firstExperiment.getFirst();
                    case "SecondExperiment" -> FXMLs.EXPERIMENTS_SECOND_1;
                    case "ThirdExperiment" -> FXMLs.EXPERIMENTS_THIRD;
                    default -> throw new IllegalStateException("Unexpected value: " + id);
                }
        );
    }

    public void backToPreviousScreen(ActionEvent event) {
        String id = ((Node) event.getSource()).getScene().getRoot().getId();

        final int numberOfPreviousFXML = Integer.parseInt(id.substring(id.length() - 1)) - 2;
        ModelUtil.changeScreen(event,
                switch (id.substring(0, id.length() - 1)){
                    case "FirstExperiment" -> FXMLs.firstExperiment.get(numberOfPreviousFXML);
                    default -> throw new IllegalStateException("Unexpected value: " + id);
                }
        );
    }

    public void goToNextScreen(ActionEvent event) {
        String id = ((Node) event.getSource()).getScene().getRoot().getId();

        final int numberOfNextFXML = Integer.parseInt(id.substring(id.length() - 1));
        ModelUtil.changeScreen(event,
                switch (id.substring(0, id.length() - 1)){
                    case "FirstExperiment" -> FXMLs.firstExperiment.get(numberOfNextFXML);
                    default -> throw new IllegalStateException("Unexpected value: " + id);
                }
        );
    }

    public void startFirstExperiment(AnchorPane firstExperimentSyringe){
        animationModel.animateFirstExperiment(firstExperimentSyringe);
    }

    public void startSecondExperiment(ImageView drop, Arc waterOnCoin){
        animationModel.animateSecondExperiment(drop, waterOnCoin);
    }

    public void showDropCount(Button countHider){
        countHider.setVisible(false);
        countHider.setDisable(true);
    }

    public void hideDropCount(Button countHider){
        countHider.setDisable(false);
        countHider.setVisible(true);
    }
}
