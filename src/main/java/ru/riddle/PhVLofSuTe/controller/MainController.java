package ru.riddle.PhVLofSuTe.controller;

import javafx.event.ActionEvent;
import ru.riddle.PhVLofSuTe.model.menu.MainModel;

public class MainController {

    private final MainModel model;

    public MainController() {
        model = new MainModel();
    }

    public void handleBackButtonAction(ActionEvent event) {
        model.backToMenuScreen(event);
    }

    public void handleTheoryButtonAction(ActionEvent event) {
        model.openTheory(event);
    }

    public void handleExperimentsButtonAction(ActionEvent event) {

    }
}
