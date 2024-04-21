package ru.riddle.PhVLofSuTe.controller;

import javafx.event.ActionEvent;
import ru.riddle.PhVLofSuTe.model.experiments.ExperimentsModel;

public class ExperimentsController {

    private final ExperimentsModel model;

    public ExperimentsController() {
        this.model = new ExperimentsModel();
    }

    public void handleExperimentButtonAction(ActionEvent event) {
        model.openExperiment(event);
    }

    public void handleLeaveButtonAction(ActionEvent event) {
        model.leaveExperiments(event);
    }
}
