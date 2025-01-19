package ru.riddle.phVLofSuTe.viewModel.tasks;

import javafx.event.ActionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.ViewModel;
import ru.riddle.phVLofSuTe.model.view.ViewManager;
import ru.riddle.phVLofSuTe.model.view.ViewName;

public class GeneratedTasksViewModel implements ViewModel {

    private static final Logger logger = LoggerFactory.getLogger(GeneratedTasksViewModel.class);

    public void leaveGeneratedTasks(ActionEvent event){
        logger.debug("Leaving generated tasks");
        ViewManager.changeScreen(event, ViewName.TASKS_GENERATOR);
    }
}