package ru.riddle.phVLofSuTe.viewModel.tasks;

import de.saxsys.mvvmfx.Initialize;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.ViewModel;

public class TaskResultCellViewModel implements ViewModel {

    private static final Logger logger = LoggerFactory.getLogger(TaskResultCellViewModel.class);

    private final StringProperty taskNumber = new SimpleStringProperty();
    private final StringProperty rightAnswer = new SimpleStringProperty();
    private final StringProperty yourAnswer = new SimpleStringProperty();


    public StringProperty taskNumberProperty() {
        return taskNumber;
    }

    public StringProperty rightAnswerProperty() {
        return rightAnswer;
    }

    public StringProperty yourAnswerProperty() {
        return yourAnswer;
    }

    @Initialize
    private void initialize(){
        logger.debug("Initializing...");

    }
}