package ru.riddle.phVLofSuTe.viewModel.tasks;

import de.saxsys.mvvmfx.Scope;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import ru.riddle.phVLofSuTe.model.data.json.Task;

import java.util.List;

public class GeneratorInfoScope implements Scope {
    private final ListProperty<Task> generatedTasks = new SimpleListProperty<>();

    public GeneratorInfoScope(List<Task> generatedTasks){
        this.generatedTasks.set(FXCollections.observableArrayList(generatedTasks));
    }

    public ListProperty<Task> generatedTasksProperty(){
        return generatedTasks;
    }
}
