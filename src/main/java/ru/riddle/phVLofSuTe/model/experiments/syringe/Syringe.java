package ru.riddle.phVLofSuTe.model.experiments.syringe;

import javafx.scene.layout.AnchorPane;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

public class Syringe extends AnchorPane{

    private int countOfParts = 6; //default count of parts = 6

    public Syringe(){
        ModelUtil.downloadCustomComponentFXML(FXMLs.SYRINGE, this);
    }

    public Syringe(int countOfParts){
        this();
        this.countOfParts = countOfParts;
    }

    private void buildSyringe(){
        for(int i = countOfParts; i > 0; i--){

        }
    }
}
