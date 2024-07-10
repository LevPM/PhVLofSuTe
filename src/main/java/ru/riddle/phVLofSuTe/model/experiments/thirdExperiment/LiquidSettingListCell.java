package ru.riddle.phVLofSuTe.model.experiments.thirdExperiment;

import javafx.scene.control.ListCell;
import ru.riddle.phVLofSuTe.model.experiments.Liquid;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

public class LiquidSettingListCell extends ListCell<Liquid> {

    public LiquidSettingListCell(){
        ModelUtil.downloadCustomComponentFXML(FXMLs.LIQUID_SETTING, this);
    }

    @Override
    protected void updateItem(Liquid item, boolean empty){

    }
}
