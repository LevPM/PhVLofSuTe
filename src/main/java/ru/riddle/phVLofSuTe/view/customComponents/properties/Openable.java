package ru.riddle.phVLofSuTe.view.customComponents.properties;

import javafx.beans.property.BooleanProperty;

public interface Openable {
    boolean getIsOpen();

    void setIsOpen(boolean isOpen);

    BooleanProperty isOpenProperty();
}
