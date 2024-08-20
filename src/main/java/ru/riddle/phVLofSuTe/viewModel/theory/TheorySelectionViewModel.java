package ru.riddle.phVLofSuTe.viewModel.theory;

import javafx.event.ActionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.ViewModel;
import ru.riddle.phVLofSuTe.model.ViewManager;
import ru.riddle.phVLofSuTe.model.ViewName;

public class TheorySelectionViewModel implements ViewModel {

    private static final Logger logger = LoggerFactory.getLogger(TheorySelectionViewModel.class);

    public void openExamplesMenu(ActionEvent event){
        logger.debug("opening theory examples menu");
        ViewManager.changeScreen(event, ViewName.THEORY_EXAMPLES_SELECTION);
    }

    public void openTheory(ActionEvent event){

    }

    public void backToTheoryExperimentsMenu(ActionEvent event) {
        logger.debug("Backing to Menu TE screen");
        ViewManager.changeScreen(event, ViewName.MENU_TE);
    }
}