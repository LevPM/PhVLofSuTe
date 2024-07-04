package ru.riddle.phVLofSuTe.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import ru.riddle.phVLofSuTe.model.experiments.ThirdExperimentModel;
import ru.riddle.phVLofSuTe.model.experiments.TypesOfLiquids;

import java.net.URL;
import java.util.ResourceBundle;

public class ThirdExperimentController implements Initializable {

    @FXML
    private ComboBox<TypesOfLiquids> liquidComboBox;

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
        this.model = new ThirdExperimentModel();

    }
}
