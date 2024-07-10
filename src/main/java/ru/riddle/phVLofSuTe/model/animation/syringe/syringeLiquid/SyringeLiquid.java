package ru.riddle.phVLofSuTe.model.animation.syringe.syringeLiquid;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import ru.riddle.phVLofSuTe.model.animation.Fillable;
import ru.riddle.phVLofSuTe.model.experiments.Liquid;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

public class SyringeLiquid extends Group implements Fillable {

    private final int countOfSegments;
    private final int segmentHeight;

    private final Liquid liquidType;

    public SyringeLiquid(int countOfSegment, int segmentHeight, Liquid liquidType){
        ModelUtil.downloadCustomComponentFXML(FXMLs.SYRINGE_LIQUID, this);
        this.countOfSegments = countOfSegment;
        this.segmentHeight = segmentHeight;
        this.liquidType = liquidType;
        buildSyringeLiquid();
        this.getChildren().add(new SyringeLiquidTip(this.liquidType));
    }

    private void buildSyringeLiquid(){
        for(int i = 0; i < countOfSegments; i++){
            this.getChildren().add(new SyringeLiquidSegment(i, segmentHeight, liquidType));
        }
    }

    @Override
    public void fill(Color color) {
        this.getChildren().forEach(children -> {
            if(children instanceof Fillable fillable){
                fillable.fill(color);
            }
        });
    }
}