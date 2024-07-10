package ru.riddle.phVLofSuTe.model.experiments.thirdExperiment;

import javafx.fxml.FXML;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import ru.riddle.phVLofSuTe.model.experiments.Liquid;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

public class LiquidSettingListCell extends ListCell<Liquid> {

    @FXML
    private Label liquidNameLabel;

    @FXML
    private Circle liquidColorCircle;

    public LiquidSettingListCell(){
        ModelUtil.downloadCustomComponentFXML(FXMLs.LIQUID_SETTING, this);
    }

    @Override
    protected void updateItem(Liquid item, boolean empty){
        super.updateItem(item, empty);
        if(empty || item == null){
            setText(null);
            setContentDisplay(ContentDisplay.TEXT_ONLY);
        } else {
            liquidNameLabel.setTextFill(Color.BLACK);
            if(this.isSelected()){
                liquidNameLabel.setTextFill(Color.NAVY);
            }

            liquidNameLabel.setText(item.getName());
            liquidColorCircle.setFill(item.getColor());

            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        }
    }
}
