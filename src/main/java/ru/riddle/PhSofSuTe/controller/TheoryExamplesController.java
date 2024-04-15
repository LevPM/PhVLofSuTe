package ru.riddle.PhSofSuTe.controller;

import javafx.event.ActionEvent;
import ru.riddle.PhSofSuTe.model.theory.TheoryExamplesModel;

public class TheoryExamplesController {

    private final TheoryExamplesModel model;

    public TheoryExamplesController() {
        this.model = new TheoryExamplesModel();
    }

    public void handleNextButtonAction(ActionEvent event) {
        model.goToNextScreen(event);
    }

    public void handlePreviousButtonAction(ActionEvent event) {
        model.backToPreviousScreen(event);
    }

    public void handleBackButtonAction(ActionEvent event) {
        model.backToExamplesMenu(event);
    }
}
