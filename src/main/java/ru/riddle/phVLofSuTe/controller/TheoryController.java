package ru.riddle.phVLofSuTe.controller;

import javafx.event.ActionEvent;
import ru.riddle.phVLofSuTe.controller.model.theory.TheoryModel;

@Deprecated
public class TheoryController {

    private final TheoryModel model;

    public TheoryController(){
        model = new TheoryModel();
    }

    public void handleLeaveButtonAction(ActionEvent event) {
        model.leaveTheory(event);
    }

    public void handleNextButtonAction(ActionEvent event) {
        model.goToNextScreen(event);
    }

    public void handlePreviousButtonAction(ActionEvent event) {
        model.backToPreviousScreen(event);
    }

    public void handleExampleButtonAction(ActionEvent event) {
        model.openExample(event);
    }

    public void handleBackButtonAction(ActionEvent event) {
        model.backToTheoryExperimentsMenuScreen(event);
    }

    public void handleExamplesButtonAction(ActionEvent event) {
        model.openExamplesMenuScreen(event);
    }

    public void handleTheoryButtonAction(ActionEvent event) {
        model.openTheory(event);
    }
}
