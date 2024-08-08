package ru.riddle.phVLofSuTe.model.customComponents.properties;

import javafx.beans.property.IntegerProperty;

public interface Segmentable{

    int getCountOfSegments();

    void setCountOfSegments(int countOfSegments);

    IntegerProperty countOfSegmentsProperty();
}
