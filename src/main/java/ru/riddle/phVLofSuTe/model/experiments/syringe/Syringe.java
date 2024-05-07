package ru.riddle.phVLofSuTe.model.experiments.syringe;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

public class Syringe extends AnchorPane{

    @FXML
    private AnchorPane syringe;

    private int countOfParts = 6; //default count of parts = 6

    public Syringe(){
        ModelUtil.downloadCustomComponentFXML(FXMLs.SYRINGE, this);
    }

    public Syringe(int countOfParts){
        this();
        this.countOfParts = countOfParts;
    }

    private void buildSyringe(){
    }
}
