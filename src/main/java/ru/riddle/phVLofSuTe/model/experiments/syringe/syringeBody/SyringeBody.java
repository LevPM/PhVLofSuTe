package ru.riddle.phVLofSuTe.model.experiments.syringe.syringeBody;

import javafx.scene.Group;
import ru.riddle.phVLofSuTe.model.experiments.Liquid;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

public class SyringeBody extends Group {

    private final int countOfSegments;
    private final int segmentHeight;

    public SyringeBody(int countOfSegments, int segmentHeight){
        ModelUtil.downloadCustomComponentFXML(FXMLs.SYRINGE_BODY, this);
        this.countOfSegments = countOfSegments;
        this.segmentHeight = segmentHeight;
        buildSyringeBody();
        this.getChildren().add(new SyringeTip());
    }

    private void buildSyringeBody(){
        for(int i = 0; i < countOfSegments; i++){
            this.getChildren().add(new SyringeBodySegment(i, segmentHeight, Liquid.WATER));
        }
    }
}
