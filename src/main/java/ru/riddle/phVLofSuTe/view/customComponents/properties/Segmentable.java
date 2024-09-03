package ru.riddle.phVLofSuTe.view.customComponents.properties;

import javafx.beans.property.IntegerProperty;

public interface Segmentable{

    int getCountOfSegments();

    void setCountOfSegments(int countOfSegments);

    IntegerProperty countOfSegmentsProperty();
}
