package ru.riddle.controller;

import javafx.event.ActionEvent;
import ru.riddle.model.TheoryModel;

import java.io.IOException;

public class TheoryController {

    private TheoryModel model;

    public TheoryController(){
        try{
            model = new TheoryModel();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleLeaveButtonAction(ActionEvent event) {
        model.leaveTheory(event);
    }

    public void handleNextButtonAction(ActionEvent event) {

    }

    public void handlePreviousButtonAction(ActionEvent event) {
    }
}
