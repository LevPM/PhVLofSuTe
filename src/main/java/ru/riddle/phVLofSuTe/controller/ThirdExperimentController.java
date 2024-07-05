package ru.riddle.phVLofSuTe.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import ru.riddle.phVLofSuTe.model.experiments.ThirdExperimentModel;
import ru.riddle.phVLofSuTe.model.experiments.Liquid;
import ru.riddle.phVLofSuTe.model.experiments.syringe.LiquidContainer;
import ru.riddle.phVLofSuTe.model.experiments.syringe.Syringe;

import java.net.URL;
import java.util.ResourceBundle;

public class ThirdExperimentController implements Initializable {

    @FXML
    private ComboBox<Liquid> liquidComboBox;

    @FXML
    private AnchorPane thirdExperimentSyringe;

    @FXML
    private Syringe syringe;

    @FXML
    private LiquidContainer liquidContainer;

    private
    ThirdExperimentModel model;

    public void handleStartThirdExperimentButton(ActionEvent event) {
        syringe.animateWithContainer(liquidContainer);
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
