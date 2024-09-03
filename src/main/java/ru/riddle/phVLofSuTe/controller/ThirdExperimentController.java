package ru.riddle.phVLofSuTe.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import ru.riddle.phVLofSuTe.controller.model.experiments.thirdExperiment.LiquidSettingListCell;
import ru.riddle.phVLofSuTe.controller.model.experiments.thirdExperiment.ThirdExperimentModel;
import ru.riddle.phVLofSuTe.controller.model.customComponents.Drop;
import ru.riddle.phVLofSuTe.controller.model.customComponents.LiquidContainer;
import ru.riddle.phVLofSuTe.controller.model.customComponents.Syringe;
import ru.riddle.phVLofSuTe.model.data.json.liquid.Liquid;

import java.net.URL;
import java.util.ResourceBundle;

@Deprecated
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

    @FXML
    private Button setDefaultButton;

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

        setDefaultButton.setOnAction(event -> {
            liquidComboBox.setValue(null);
            isOpenSettingToggleButton.setSelected(false);
            isOpenSettingToggleButton.getOnAction().handle(null);
            countOfSegmentsSlider.setValue(5);
        });
    }

    private void initializeLiquidComboBox(ComboBox<Liquid> liquidComboBox){
        liquidComboBox.getItems().addAll(null, null);
        liquidComboBox.setValue(null);

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
        setDefaultButton.setDisable(true);

        syringe.setOnAnimationFinished(event -> {
            liquidComboBox.setDisable(false);

            isOpenSettingToggleButton.setDisable(false);
            isOpenSettingToggleButton.setSelected(false);
            isOpenSettingToggleButton.setText("Закрыт");
            isOpenSettingToggleButton.setTextFill(Color.NAVY);

            countOfSegmentsSlider.setDisable(false);

            setDefaultButton.setDisable(false);
        });
    }
}
