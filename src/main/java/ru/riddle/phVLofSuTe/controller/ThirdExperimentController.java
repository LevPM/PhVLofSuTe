package ru.riddle.phVLofSuTe.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import ru.riddle.phVLofSuTe.model.experiments.thirdExperiment.LiquidSettingListCell;
import ru.riddle.phVLofSuTe.model.experiments.thirdExperiment.ThirdExperimentModel;
import ru.riddle.phVLofSuTe.model.customComponents.Liquid;
import ru.riddle.phVLofSuTe.model.customComponents.Drop;
import ru.riddle.phVLofSuTe.model.customComponents.LiquidContainer;
import ru.riddle.phVLofSuTe.model.customComponents.syringe.Syringe;

import java.net.URL;
import java.util.ResourceBundle;

public class ThirdExperimentController implements Initializable {

    @FXML
    private ComboBox<Liquid> liquidComboBox;

    @FXML
    private ToggleButton isOpenSettingToggleButton;

    @FXML
    private Syringe syringe;

    @FXML
    private LiquidContainer liquidContainer;

    @FXML
    private Drop drop;

    @FXML
    private Slider countOfSegmentsSlider;

    private ThirdExperimentModel model;

    public void handleStartThirdExperimentButton() {
        setOnSyringeAnimationFinished();
        syringe.animateWithContainer(liquidContainer, drop);
    }

    public void handleLeaveButtonAction(ActionEvent event) {
        model.leaveExperiment(event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.model = new ThirdExperimentModel();
        initializeLiquidComboBox(liquidComboBox);
        initializeIsOpenSettingToggleButton(isOpenSettingToggleButton);
        initializeCountOfSegmentsSlider(countOfSegmentsSlider);
    }

    private void initializeLiquidComboBox(ComboBox<Liquid> liquidComboBox){
        liquidComboBox.getItems().addAll(Liquid.values());
        liquidComboBox.setValue(Liquid.WATER);

        Callback<ListView<Liquid>, ListCell<Liquid>> cellFactory = lv -> new LiquidSettingListCell();

        liquidComboBox.setCellFactory(cellFactory);
        liquidComboBox.setButtonCell(cellFactory.call(null));

        liquidComboBox.setOnAction(event -> {
            syringe.setLiquidType(liquidComboBox.getValue());
            liquidContainer.setLiquidType(liquidComboBox.getValue());
            drop.setLiquidType(liquidComboBox.getValue());
        });
    }

    private void initializeIsOpenSettingToggleButton(ToggleButton isOpenSettingToggleButton){
        isOpenSettingToggleButton.setOnAction(event -> {
            isOpenSettingToggleButton.setText(isOpenSettingToggleButton.isSelected() ? "Открыт" : "Закрыт");
            isOpenSettingToggleButton.setTextFill(isOpenSettingToggleButton.isSelected() ? Color.MAROON : Color.NAVY);
            syringe.setIsOpen(isOpenSettingToggleButton.isSelected());
        });
    }

    private void initializeCountOfSegmentsSlider(Slider countOfSegmentsSlider){
        syringe.setCountOfSegments((int) countOfSegmentsSlider.getValue());
        countOfSegmentsSlider.valueProperty().addListener(event -> syringe.setCountOfSegments((int) countOfSegmentsSlider.getValue()));
    }

    private void setOnSyringeAnimationFinished(){
        liquidComboBox.setDisable(true);
        isOpenSettingToggleButton.setDisable(true);
        countOfSegmentsSlider.setDisable(true);

        syringe.setOnAnimationFinished(event -> {
            liquidComboBox.setDisable(false);

            isOpenSettingToggleButton.setDisable(false);
            isOpenSettingToggleButton.setSelected(false);
            isOpenSettingToggleButton.setText("Закрыт");
            isOpenSettingToggleButton.setTextFill(Color.NAVY);

            countOfSegmentsSlider.setDisable(false);
        });
    }
}
