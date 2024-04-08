package ru.riddle.controller;

import javafx.event.ActionEvent;
import ru.riddle.model.TheoryModel;

public class TheoryController {

    private final TheoryModel model;

    public TheoryController(){
        model = new TheoryModel();
    }

    public void handleLeaveButtonAction(ActionEvent event) {
        model.leaveTheory(event);
    }

    public void handleNextButtonAction(ActionEvent event) {

    }
}
