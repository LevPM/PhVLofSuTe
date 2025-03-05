package ru.riddle.phVLofSuTe.viewModel.tasks;

import de.saxsys.mvvmfx.Scope;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GeneratedTaskDataScope implements Scope {

    private final StringProperty level = new SimpleStringProperty();
    private final StringProperty condition = new SimpleStringProperty();

    public GeneratedTaskDataScope(int level, String condition) {
        this.level.set(Integer.toString(level));
        this.condition.set(condition);
    }

    public StringProperty levelProperty() {
        return level;
    }

    public StringProperty conditionProperty() {
        return condition;
    }
}
