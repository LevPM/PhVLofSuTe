package ru.riddle.PhVLofSuTe.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import ru.riddle.PhVLofSuTe.model.experiments.ExperimentsModel;

public class ExperimentsController{

    private final ExperimentsModel model;

    @FXML
    private ImageView syringePiston;


    public ExperimentsController() {
        this.model = new ExperimentsModel();
    }

    public void handleExperimentButtonAction(ActionEvent event) {
        model.openExperiment(event);
    }

    public void handleLeaveButtonAction(ActionEvent event) {
        model.leaveExperiments(event);
    }

    public void handleStartFirstExperimentButton(ActionEvent event) {
        model.startFirstExperiment(event, syringePiston);
    }

    public void handleDropCountButtonAction(ActionEvent event) {
        model.showDropCount(event);
    }
}
