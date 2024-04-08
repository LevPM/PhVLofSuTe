package ru.riddle.controller;

import javafx.event.ActionEvent;
import ru.riddle.model.menu.MainModel;

public class MainController {

    private final MainModel model;

    public MainController() {
        model = new MainModel();
    }


    public void handleEButtonAction(ActionEvent event) {
    }

    public void handleCEButtonAction(ActionEvent event) {
    }

    public void handleSButtonAction(ActionEvent event) {
    }

    public void handleCFButtonAction(ActionEvent event) {
    }

    public void handleFButtonAction(ActionEvent event) {
    }

    public void handleLButtonAction(ActionEvent event) {
    }

    public void handleBackButtonAction(ActionEvent event) {
        model.backToMenuScreen(event);
    }

    public void handleTheoryButtonAction(ActionEvent event) {
        model.openTheory(event);
    }
}
