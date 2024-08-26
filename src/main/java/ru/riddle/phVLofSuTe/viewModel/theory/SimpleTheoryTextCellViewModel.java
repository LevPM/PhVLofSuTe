package ru.riddle.phVLofSuTe.viewModel.theory;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.ViewModel;

public class SimpleTheoryTextCellViewModel implements ViewModel {

    private static final Logger logger = LoggerFactory.getLogger(SimpleTheoryTextCellViewModel.class);

    private final StringProperty text = new SimpleStringProperty("");

    public SimpleTheoryTextCellViewModel(String text) {
        this.text.set(text);
    }

    public StringProperty textProperty() {
        return text;
    }
}