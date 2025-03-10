package ru.riddle.phVLofSuTe.viewModel.tasks;

import de.saxsys.mvvmfx.Scope;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import ru.riddle.phVLofSuTe.model.Triple;

import java.util.List;

public class ResultsScope implements Scope {
    private final ListProperty<Triple<String, String, String>> results = new SimpleListProperty<>();

    public ResultsScope(List<Triple<String, String, String>> results){
        this.results.set(FXCollections.observableArrayList(results));
    }

    public ListProperty<Triple<String, String, String>> resultsProperty() {
        return results;
    }
}
