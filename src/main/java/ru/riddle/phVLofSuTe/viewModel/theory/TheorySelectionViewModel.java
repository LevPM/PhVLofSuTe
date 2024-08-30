package ru.riddle.phVLofSuTe.viewModel.theory;

import javafx.event.ActionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.ViewModel;
import ru.riddle.phVLofSuTe.model.data.json.TheoryChapter;
import ru.riddle.phVLofSuTe.model.view.ViewManager;
import ru.riddle.phVLofSuTe.model.view.ViewName;
import ru.riddle.phVLofSuTe.viewModel.SelectedDataScope;

public class TheorySelectionViewModel implements ViewModel {

    private static final Logger logger = LoggerFactory.getLogger(TheorySelectionViewModel.class);

    public void openExamplesMenu(ActionEvent event){
        logger.debug("Opening theory examples menu");
        ViewManager.changeScreen(event, ViewName.THEORY_EXAMPLES_SELECTION);
    }

    public void openBasicTheory(ActionEvent event){
        logger.debug("Opening basic theory"); //TODO: Change message
        ViewManager.changeScreen(event, ViewName.THEORY_BASIC_THEORY_CHAPTER, new SelectedDataScope<>(1, TheoryChapter.class ));
    }

    public void backToTheoryExperimentsMenu(ActionEvent event) {
        logger.debug("Backing to Menu TE screen");
        ViewManager.changeScreen(event, ViewName.MENU_TE);
    }
}