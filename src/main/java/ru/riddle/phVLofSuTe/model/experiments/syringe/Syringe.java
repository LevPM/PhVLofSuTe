package ru.riddle.phVLofSuTe.model.experiments.syringe;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import ru.riddle.phVLofSuTe.model.experiments.syringe.syringeBody.SyringeBody;
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

    private SyringePiston piston;
    private SyringeBody body;

    public Syringe(){
        ModelUtil.downloadCustomComponentFXML(FXMLs.SYRINGE, this);
    }

    private void buildSyringe(){
        piston = new SyringePiston(countOfSegments, SEGMENT_HEIGHT);
        body = new SyringeBody(countOfSegments, SEGMENT_HEIGHT);

        syringe.getChildren().addAll(
                piston,
                body
        );
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buildSyringe();
    }
}
