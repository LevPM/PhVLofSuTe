package ru.riddle.phVLofSuTe.viewModel.tasks;

import de.saxsys.mvvmfx.Scope;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GeneratedTaskDataScope implements Scope {

    private final StringProperty title = new SimpleStringProperty();
    private final StringProperty level = new SimpleStringProperty();
    private final StringProperty condition = new SimpleStringProperty();

    public GeneratedTaskDataScope(String title, int level, String condition) {
        this.title.set(title);
        this.level.set(Integer.toString(level));
        this.condition.set(condition);
    }

    public StringProperty titleProperty() {
        return title;
    }

    public StringProperty levelProperty() {
        return level;
    }

    public StringProperty conditionProperty() {
        return condition;
    }
}
