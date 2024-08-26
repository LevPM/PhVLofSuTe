package ru.riddle.phVLofSuTe.viewModel.theory.examples;

import javafx.event.ActionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.ViewModel;
import ru.riddle.phVLofSuTe.model.Example;
import ru.riddle.phVLofSuTe.model.ViewManager;
import ru.riddle.phVLofSuTe.model.ViewName;
import ru.riddle.phVLofSuTe.viewModel.theory.SelectedDataScope;

public class TheoryExamplesSelectionViewModel implements ViewModel {

    private static final Logger logger = LoggerFactory.getLogger(TheoryExamplesSelectionViewModel.class);

    public void backToTheorySelection(ActionEvent event){
        logger.debug("Backing to TheorySelection...");
        ViewManager.changeScreen(event, ViewName.THEORY_SELECTION);
    }

    public void openExample(ActionEvent event, int id){
        logger.debug("Opening example...");
        ViewManager.changeScreen(event, ViewName.THEORY_BASIC_EXAMPLE, new SelectedDataScope<>(id, Example.class));
    }
}