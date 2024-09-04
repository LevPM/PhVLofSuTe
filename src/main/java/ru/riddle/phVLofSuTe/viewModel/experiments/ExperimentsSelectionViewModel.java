package ru.riddle.phVLofSuTe.viewModel.experiments;

import javafx.event.ActionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.ViewModel;
import ru.riddle.phVLofSuTe.model.view.ViewManager;
import ru.riddle.phVLofSuTe.model.view.ViewName;

public class ExperimentsSelectionViewModel implements ViewModel {

    private static final Logger logger = LoggerFactory.getLogger(ExperimentsSelectionViewModel.class);

    public void leaveExperimentsSelection(ActionEvent event){
        logger.debug("Leaving experiments selection");
        ViewManager.changeScreen(event, ViewName.MENU_TE);
    }

    public void openExperiment(ActionEvent event, int id, boolean isStandard){
        logger.debug("opening experiment. id:{}, isStandard: {}", id, isStandard);
    }
}