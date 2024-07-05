package ru.riddle.phVLofSuTe.model.experiments.syringe.syringePiston;

import javafx.scene.Group;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

public class SyringePiston extends Group {

    private final int countOfSegments;
    private final int segmentHeight;

    public SyringePiston(int countOfSegment, int segmentHeight){
        ModelUtil.downloadCustomComponentFXML(FXMLs.SYRINGE_PISTON, this);
        this.countOfSegments = countOfSegment;
        this.segmentHeight = segmentHeight;
        int pistonHeight = countOfSegment * segmentHeight + 10 + 1;
        buildSyringePistonRod();
        this.getChildren().addAll(
                new SyringePistonTip(),
                new SyringePistonCap(pistonHeight)
        );
    }

    private void buildSyringePistonRod(){
        for(int i = 0; i < countOfSegments; i++){
            this.getChildren().add(new SyringePistonRodSegment(i, segmentHeight));
        }
    }
}
