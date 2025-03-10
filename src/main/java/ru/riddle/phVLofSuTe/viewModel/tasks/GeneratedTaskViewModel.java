package ru.riddle.phVLofSuTe.viewModel.tasks;

import de.saxsys.mvvmfx.Initialize;
import de.saxsys.mvvmfx.InjectScope;
import javafx.beans.property.StringProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.ViewModel;

public class GeneratedTaskViewModel implements ViewModel {

    private static final Logger logger = LoggerFactory.getLogger(GeneratedTaskViewModel.class);

    @InjectScope
    GeneratedTaskDataScope generatedTask;

    public StringProperty conditionProperty(){
        return generatedTask.conditionProperty();
    }

    public StringProperty levelProperty(){
        return generatedTask.levelProperty();
    }

    public void saveAnswer(String answer){
        generatedTask.answerProperty().set(answer);
    }

    @Initialize
    private void initialize(){
        logger.debug("Initializing...");
    }
}