package ru.riddle.phVLofSuTe.viewModel.theory.examples;

import de.saxsys.mvvmfx.Scope;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.riddle.phVLofSuTe.model.Example;
import ru.riddle.phVLofSuTe.model.JSONDataManager;

public class SelectedExampleScope implements Scope {

    private static final Logger logger = LoggerFactory.getLogger(SelectedExampleScope.class);

    private final ObjectProperty<Example> example = new SimpleObjectProperty<>();

    public ObjectProperty<Example> exampleProperty() {
        return example;
    }

    public Example getExample() {
        return example.get();
    }

    public SelectedExampleScope(int id){
        logger.trace("Creating scope with id: {}", id);
        this.example.set(JSONDataManager.getById(id, Example.class));
    }
}
