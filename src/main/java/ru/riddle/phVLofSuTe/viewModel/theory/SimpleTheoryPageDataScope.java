package ru.riddle.phVLofSuTe.viewModel.theory;

import de.saxsys.mvvmfx.Scope;
import javafx.beans.property.*;
import javafx.collections.FXCollections;

import java.util.List;

public class SimpleTheoryPageDataScope implements Scope {

    private final StringProperty title = new SimpleStringProperty();

    private final ListProperty<String> textList = new SimpleListProperty<>();

    private final ObjectProperty<ExamplePageType> type = new SimpleObjectProperty<>();

    public SimpleTheoryPageDataScope(List<String> text, ExamplePageType type) {
        this.textList.set(FXCollections.observableArrayList(text));
        this.type.set(type);
    }

    public SimpleTheoryPageDataScope(String text, ExamplePageType type) {
        this(List.of(text), type);
    }

    public SimpleTheoryPageDataScope(List<String> text, ExamplePageType type, String title) {
        this(text, type);
        this.title.set(title);
    }

    public SimpleTheoryPageDataScope(String text, ExamplePageType type, String title) {
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
