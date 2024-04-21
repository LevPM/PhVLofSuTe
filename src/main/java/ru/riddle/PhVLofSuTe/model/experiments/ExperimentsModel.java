package ru.riddle.PhVLofSuTe.model.experiments;

import javafx.event.ActionEvent;
import ru.riddle.PhVLofSuTe.model.util.FXMLs;
import ru.riddle.PhVLofSuTe.model.util.ModelUtil;

public class ExperimentsModel {

    public void leaveExperiments(ActionEvent event){
        ModelUtil.changeScreen(event, FXMLs.MENU_TE_SELECTION);
    }
}
