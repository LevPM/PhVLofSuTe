package ru.riddle.phVLofSuTe.viewModel.theory.examples;

import de.saxsys.mvvmfx.Scope;
import javafx.beans.property.*;
import javafx.collections.FXCollections;

import java.util.List;

public class ExamplePageDataScope implements Scope {

    private final StringProperty title = new SimpleStringProperty();

    private final ListProperty<String> textList = new SimpleListProperty<>();

    private final ObjectProperty<PageType> type = new SimpleObjectProperty<>();

    public ExamplePageDataScope(List<String> text, PageType type) {
        this.textList.set(FXCollections.observableArrayList(text));
        this.type.set(type);
    }

    public ExamplePageDataScope(String text, PageType type) {
        this(List.of(text), type);
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public PageType getType() {
        return type.get();
    }

    public ObjectProperty<PageType> typeProperty() {
        return type;
    }

    public ListProperty<String> textListProperty() {
        return textList;
    }

    public enum PageType{
        CONDITION,
        GIVEN,
        TO_FIND,
        DECISION,
        ANSWER
    }
}
