package ru.riddle.PhVLofSuTe.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.util.Pair;
import ru.riddle.PhVLofSuTe.model.experiments.ThirdExperimentModel;
import ru.riddle.PhVLofSuTe.model.util.FXMLs;

import java.net.URL;
import java.util.ResourceBundle;

public class ThirdExperimentController implements Initializable {

    @FXML
    private ComboBox<Pair<String, FXMLs>> liquidComboBox;

    @FXML
    private AnchorPane thirdExperimentSyringe;

    private
    ThirdExperimentModel model;

    public void handleStartThirdExperimentButton(ActionEvent event) {

    }

    public void handleSaveLiquidFromComboBoxButtonAction(ActionEvent event) {

    }

    public void handleLeaveButtonAction(ActionEvent event) {
        model.leaveExperiment(event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.model = new ThirdExperimentModel(thirdExperimentSyringe);
    }
}
