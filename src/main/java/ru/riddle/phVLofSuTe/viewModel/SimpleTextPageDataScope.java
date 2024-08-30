package ru.riddle.phVLofSuTe.viewModel;

import de.saxsys.mvvmfx.Scope;
import javafx.beans.property.*;
import javafx.collections.FXCollections;

import java.util.List;

public class SimpleTextPageDataScope implements Scope {

    private final StringProperty title = new SimpleStringProperty();

    private final ListProperty<String> textList = new SimpleListProperty<>();

    private final StringProperty styleClass = new SimpleStringProperty();

    public SimpleTextPageDataScope(List<String> text, String styleClass) {
        this.textList.set(FXCollections.observableArrayList(text));
        this.styleClass.set(styleClass);
    }

    public SimpleTextPageDataScope(String text, String styleClass) {
        this(List.of(text), styleClass);
    }

    public SimpleTextPageDataScope(List<String> text, String styleClass, String title) {
        this(text, styleClass);
        this.title.set(title);
    }

    public SimpleTextPageDataScope(String text, String styleClass, String title) {
        this(List.of(text), styleClass, title);
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public ListProperty<String> textListProperty() {
        return textList;
    }

    public String getStyleClass() {
        return styleClass.get();
    }
}
