package ru.riddle.phVLofSuTe.model.animation.syringe.syringePiston;

import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
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
        createBackground(pistonHeight - 11);
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

    private void createBackground(int pistonHeight){
        Rectangle background = new Rectangle(60, pistonHeight, Color.PAPAYAWHIP);
        background.setX(-30);
        background.setY(-pistonHeight - 11);
        this.getChildren().add(background);
    }

    public Transition getTransition(Duration duration, boolean isRefilling){
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(this);
        transition.setDuration(Duration.millis(duration.toMillis() + 1000));
        transition.setByY(isRefilling ? -250 : 250);

        return transition;
    }
}
