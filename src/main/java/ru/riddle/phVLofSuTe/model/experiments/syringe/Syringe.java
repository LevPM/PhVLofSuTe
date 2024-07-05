package ru.riddle.phVLofSuTe.model.experiments.syringe;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import ru.riddle.phVLofSuTe.model.experiments.syringe.syringeBody.SyringeBodySegment;
import ru.riddle.phVLofSuTe.model.experiments.syringe.syringeBody.SyringeTip;
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

    private Group syringeBody;

    private SyringePiston piston;

    public Syringe(){
        ModelUtil.downloadCustomComponentFXML(FXMLs.SYRINGE, this);
    }

    private void buildSyringe(){
        createSyringeBody();
        piston = new SyringePiston(countOfSegments, SEGMENT_HEIGHT);

        syringe.getChildren().addAll(
                piston,
                new SyringeTip(),
                syringeBody
        );
    }

    private void createSyringeBody(){
        syringeBody = new Group();
        for(int i = 0; i < countOfSegments; i++){
            syringeBody.getChildren().add(new SyringeBodySegment(i, SEGMENT_HEIGHT));
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buildSyringe();
    }
}
