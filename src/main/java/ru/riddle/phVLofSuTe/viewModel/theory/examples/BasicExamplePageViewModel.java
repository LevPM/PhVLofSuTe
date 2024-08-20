package ru.riddle.phVLofSuTe.viewModel.theory.examples;

import de.saxsys.mvvmfx.Initialize;
import de.saxsys.mvvmfx.InjectScope;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.ViewModel;

public class BasicExamplePageViewModel implements ViewModel {

    private static final Logger logger = LoggerFactory.getLogger(BasicExamplePageViewModel.class);

    private final StringProperty styleClass = new SimpleStringProperty();

    private final ObservableList<BasicTextCellViewModel> textList = FXCollections.observableArrayList();

    @InjectScope
    ExamplePageDataScope pageDataScope;

    public StringProperty titleProperty() {
        return pageDataScope.titleProperty();
    }

    public ObservableList<BasicTextCellViewModel> textListProperty() {
        return textList;
    }

    public StringProperty styleClassProperty() {
        return styleClass;
    }

    @Initialize
    private void initialize(){
        logger.debug("Initializing...");

        textList.addAll(pageDataScope.textListProperty()
                .stream()
                .map(BasicTextCellViewModel::new)
                .toList()
        );

        switch (pageDataScope.getType()){
            case CONDITION -> {
                pageDataScope.titleProperty().set("Условие");
                styleClass.set("theory-condition-label");
            }
            case GIVEN -> {
                pageDataScope.titleProperty().set("Дано");
                styleClass.set("theory-given-label");
            }
            case TO_FIND -> {
                pageDataScope.titleProperty().set("Найти");
                styleClass.set("theory-to-find-label");
            }
            case DECISION -> {
                pageDataScope.titleProperty().set("Решение");
                styleClass.set("theory-decision-label");
            }
            case ANSWER -> {
                pageDataScope.titleProperty().set("Ответ");
                styleClass.set("theory-answer-label");
            }
        }
    }
}