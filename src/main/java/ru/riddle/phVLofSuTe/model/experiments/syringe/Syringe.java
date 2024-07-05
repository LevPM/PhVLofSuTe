package ru.riddle.phVLofSuTe.model.experiments.syringe;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import ru.riddle.phVLofSuTe.model.experiments.Liquid;
import ru.riddle.phVLofSuTe.model.experiments.syringe.syringeBody.SyringeBody;
import ru.riddle.phVLofSuTe.model.experiments.syringe.syringeLiquid.SyringeLiquid;
import ru.riddle.phVLofSuTe.model.experiments.syringe.syringePiston.SyringePiston;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

import java.net.URL;
import java.util.ResourceBundle;

public class Syringe extends AnchorPane implements Initializable {

    private static final int SEGMENT_HEIGHT = 50;

    @FXML
    private AnchorPane syringe;

    int countOfSegments = 6; //default count of parts = 6

    private SyringeLiquid liquid;
    private SyringeBody body;
    private SyringePiston piston;

    public Syringe(){
        ModelUtil.downloadCustomComponentFXML(FXMLs.SYRINGE, this);
    }

    private void buildSyringe(){
        liquid = new SyringeLiquid(countOfSegments, SEGMENT_HEIGHT, Liquid.WATER);
        body = new SyringeBody(countOfSegments, SEGMENT_HEIGHT);
        piston = new SyringePiston(countOfSegments, SEGMENT_HEIGHT);

        syringe.getChildren().addAll(
                liquid,
                body,
                piston
        );
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buildSyringe();
    }

    public void animate(){

    }
}
