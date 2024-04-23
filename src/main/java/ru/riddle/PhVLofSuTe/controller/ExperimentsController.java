package ru.riddle.PhVLofSuTe.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Arc;
import ru.riddle.PhVLofSuTe.model.experiments.ExperimentsModel;

public class ExperimentsController{

    private final ExperimentsModel model;

    @FXML
    public AnchorPane firstExperimentSyringe;

    @FXML
    private AnchorPane waterPane;

    @FXML
    private AnchorPane soapWaterPane;

    @FXML
    private Arc arcDrop;

    @FXML
    private ImageView drop;

    @FXML
    private ImageView waterBucket;

    @FXML
    private Button countHider;

    @FXML
    private ImageView syringePiston;


    @FXML
    private Arc waterOnCoin;

    @FXML
    private ImageView dropS;


    public ExperimentsController() {
        this.model = new ExperimentsModel();
    }

    public void handleExperimentButtonAction(ActionEvent event) {
        model.openExperiment(event);
    }

    public void handleLeaveButtonAction(ActionEvent event) {
        model.leaveExperiment(event);
    }

    public void handleDropHiderButtonAction() {
        model.showDropCount(countHider);
    }

    public void handleDropCountButtonAction() {
        model.hideDropCount(countHider);
    }

    public void handleBackButtonAction(ActionEvent event) {
        model.backToPreviousScreen(event);
    }

    public void handleNextButtonAction(ActionEvent event) {
        model.goToNextScreen(event);
    }

    public void handleLeaveEButtonAction(ActionEvent event) {
        model.leaveExperiments(event);
    }

    public void handleStartFirstExperimentButton() {
        model.startFirstExperiment(firstExperimentSyringe);
    }

    public void handleStartSecondExperimentButton() {
        model.startSecondExperiment(dropS, waterOnCoin);
    }

    public void handleStartThirdExperimentButton() {
        model.startThirdExperiment(waterPane, soapWaterPane);
    }
}
