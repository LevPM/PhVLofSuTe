package ru.riddle.phVLofSuTe.viewModel.theory.examples;

import javafx.event.ActionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.ViewModel;
import ru.riddle.phVLofSuTe.model.tasks.TasksGenerator;
import ru.riddle.phVLofSuTe.model.view.ViewManager;
import ru.riddle.phVLofSuTe.model.view.ViewName;
import ru.riddle.phVLofSuTe.viewModel.SelectedDataScope;

public class TheoryExamplesSelectionViewModel implements ViewModel {

    private static final Logger logger = LoggerFactory.getLogger(TheoryExamplesSelectionViewModel.class);

    public void backToTheorySelection(ActionEvent event){
        logger.debug("Backing to TheorySelection...");
        ViewManager.changeScreen(event, ViewName.THEORY_SELECTION);
    }

    public void openExample(ActionEvent event, int id){
        logger.debug("Opening example...");
        ViewManager.changeScreen(event, ViewName.THEORY_BASIC_EXAMPLE, new SelectedDataScope<>(TasksGenerator.createDefaultTask(id)));
    }
}