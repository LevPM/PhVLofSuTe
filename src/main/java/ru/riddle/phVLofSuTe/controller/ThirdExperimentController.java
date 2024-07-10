package ru.riddle.phVLofSuTe.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import ru.riddle.phVLofSuTe.model.experiments.thirdExperiment.ThirdExperimentModel;
import ru.riddle.phVLofSuTe.model.experiments.Liquid;
import ru.riddle.phVLofSuTe.model.animation.Drop;
import ru.riddle.phVLofSuTe.model.animation.LiquidContainer;
import ru.riddle.phVLofSuTe.model.animation.syringe.Syringe;

import java.net.URL;
import java.util.ResourceBundle;

public class ThirdExperimentController implements Initializable {

    @FXML
    private ComboBox<Liquid> liquidComboBox;

    @FXML
    private Syringe syringe;

    @FXML
    private LiquidContainer liquidContainer;

    @FXML
    private Drop drop;

    private
    ThirdExperimentModel model;

    public void handleStartThirdExperimentButton(ActionEvent event) {
        syringe.animateWithContainer(liquidContainer, drop);
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
