package ru.riddle.phVLofSuTe.model.customComponents.syringe.syringeBody;

import javafx.beans.property.ObjectProperty;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

public class SyringeBody extends Group{

    private final int countOfSegments;
    private final int segmentHeight;

    private ObjectProperty<Color> bodyColor;

    public SyringeBody(int countOfSegments, int segmentHeight){
        ModelUtil.downloadCustomComponentFXML(FXMLs.SYRINGE_BODY, this);
        this.countOfSegments = countOfSegments;
        this.segmentHeight = segmentHeight;
        buildSyringeBody();
        this.getChildren().addAll(
                new SyringeTip(),
                new SyringeBodyStub(countOfSegments * segmentHeight + 10)
        );
        this.getStyleClass().add("syringe-body");
    }

    private void buildSyringeBody(){
        for(int i = 0; i < countOfSegments; i++){
            this.getChildren().add(new SyringeBodySegment(i, segmentHeight));
        }
    }

}
