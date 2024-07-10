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

    private final int openY; //Translate Y when syringe is open

    private boolean isOpen = false;

    public SyringePiston(int countOfSegment, int segmentHeight){
        ModelUtil.downloadCustomComponentFXML(FXMLs.SYRINGE_PISTON, this);
        this.countOfSegments = countOfSegment;
        this.segmentHeight = segmentHeight;
        this.openY = - segmentHeight * (countOfSegments - 1);
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
        if(isOpen && isRefilling){
            return new TranslateTransition();
        }

        TranslateTransition transition = new TranslateTransition();
        transition.setNode(this);
        transition.setDuration(Duration.millis(duration.toMillis() + 1000));
        transition.setByY(isRefilling ? -segmentHeight * (countOfSegments - 1) : segmentHeight * (countOfSegments - 1));

        return transition;
    }

    private void open(){
        if(!isOpen) {
            if(!(this.getTranslateY() == openY)){
                this.setTranslateY(-segmentHeight * (countOfSegments - 1));
            }
            this.isOpen = true;
        }
    }

    private void close(){
        if(isOpen) {
            if(!(this.getTranslateY() == 0)){
                this.setTranslateY(segmentHeight * (countOfSegments - 1));
            }
            this.isOpen = false;
        }
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean isOpen) {
        if(isOpen != this.isOpen){
            if(isOpen){
                open();
            } else {
                close();
            }
        }
    }
}
