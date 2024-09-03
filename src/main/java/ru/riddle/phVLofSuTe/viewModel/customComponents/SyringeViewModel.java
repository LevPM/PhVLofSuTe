package ru.riddle.phVLofSuTe.viewModel.customComponents;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SyringeViewModel extends BorderedLiquidTankViewModel {

    private static final Logger logger = LoggerFactory.getLogger(SyringeViewModel.class);

    private static final int SEGMENT_HEIGHT = 50;

    private IntegerProperty countOfSegments;

    private static final int DEFAULT_COUNT_OF_SEGMENTS = 5;

    public IntegerProperty countOfSegmentsProperty(){
        if(countOfSegments == null){
            countOfSegments = new SimpleIntegerProperty(this, "countOfSegments", DEFAULT_COUNT_OF_SEGMENTS);
            countOfSegments.addListener(event -> rebuildSyringe());
        }
        return countOfSegments;
    }

    private void rebuildSyringe(){
        //this.getChildren().clear();
        //buildSyringe();
    }
}