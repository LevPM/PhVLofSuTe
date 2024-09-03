package ru.riddle.phVLofSuTe.controller.model.experiments.thirdExperiment;

import javafx.fxml.FXML;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.shape.Circle;
import ru.riddle.phVLofSuTe.controller.LiquidL;
import ru.riddle.phVLofSuTe.model.FXMLs;
import ru.riddle.phVLofSuTe.model.ModelUtil;

@Deprecated
public class LiquidSettingListCell extends ListCell<LiquidL> {

    @FXML
    private Label liquidNameLabel;

    @FXML
    private Circle liquidColorCircle;

    public LiquidSettingListCell(){
        ModelUtil.downloadCustomComponentFXML(FXMLs.LIQUID_SETTING, this);
    }

    @Override
    protected void updateItem(LiquidL item, boolean empty){
        super.updateItem(item, empty);
        if(empty || item == null){
            setText(null);
            setContentDisplay(ContentDisplay.TEXT_ONLY);
        } else {
            liquidNameLabel.setText(item.getName());
            liquidColorCircle.setFill(item.getColor());

            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        }
    }
}
