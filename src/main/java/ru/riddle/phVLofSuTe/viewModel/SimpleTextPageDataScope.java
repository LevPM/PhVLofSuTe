package ru.riddle.phVLofSuTe.viewModel;

import de.saxsys.mvvmfx.Scope;
import javafx.beans.property.*;
import javafx.collections.FXCollections;

import java.util.List;

public class SimpleTextPageDataScope implements Scope {

    private final StringProperty title = new SimpleStringProperty();

    private final ListProperty<String> textList = new SimpleListProperty<>();

    private final ObjectProperty<ExamplePageType> type = new SimpleObjectProperty<>();

    public SimpleTextPageDataScope(List<String> text, ExamplePageType type) {
        this.textList.set(FXCollections.observableArrayList(text));
        this.type.set(type);
    }

    public SimpleTextPageDataScope(String text, ExamplePageType type) {
        this(List.of(text), type);
    }

    public SimpleTextPageDataScope(List<String> text, ExamplePageType type, String title) {
        this(text, type);
        this.title.set(title);
    }

    public SimpleTextPageDataScope(String text, ExamplePageType type, String title) {
        this(List.of(text), type, title);
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public ExamplePageType getType() {
        return type.get();
    }

    public ObjectProperty<ExamplePageType> typeProperty() {
        return type;
    }

    public ListProperty<String> textListProperty() {
        return textList;
    }

    public enum ExamplePageType {
        CONDITION,
        GIVEN,
        TO_FIND,
        DECISION,
        ANSWER,
        BASIC_TITLE
    }
}
