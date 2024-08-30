package ru.riddle.phVLofSuTe.viewModel;

import de.saxsys.mvvmfx.Initialize;
import de.saxsys.mvvmfx.InjectScope;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.ViewModel;

public class SimpleTextPageViewModel implements ViewModel {

    private static final Logger logger = LoggerFactory.getLogger(SimpleTextPageViewModel.class);

    private final StringProperty styleClass = new SimpleStringProperty();

    private final ObservableList<SimpleTextCellViewModel> textList = FXCollections.observableArrayList();

    @InjectScope
    SimpleTextPageDataScope pageDataScope;

    public StringProperty titleProperty() {
        return pageDataScope.titleProperty();
    }

    public ObservableList<SimpleTextCellViewModel> textListProperty() {
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
                .map(SimpleTextCellViewModel::new)
                .toList()
        );

        styleClass.set(pageDataScope.getStyleClass());
    }
}