package ru.riddle.phVLofSuTe.viewModel.tasks;

import de.saxsys.mvvmfx.Scope;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class GeneratorInfoScope implements Scope {
    private final IntegerProperty countOfGeneratedTasks = new SimpleIntegerProperty();

    public GeneratorInfoScope(int countOfGeneratedTasks){
        this.countOfGeneratedTasks.set(countOfGeneratedTasks);
    }

    public IntegerProperty countOfGeneratedTasksProperty(){
        return countOfGeneratedTasks;
    }
}
