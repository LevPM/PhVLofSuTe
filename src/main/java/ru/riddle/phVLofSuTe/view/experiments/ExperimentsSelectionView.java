package ru.riddle.phVLofSuTe.view.experiments;

import javafx.event.ActionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import ru.riddle.phVLofSuTe.viewModel.experiments.ExperimentsSelectionViewModel;

public class ExperimentsSelectionView implements FxmlView<ExperimentsSelectionViewModel> {

    private static final Logger logger = LoggerFactory.getLogger(ExperimentsSelectionView.class);

    @InjectViewModel
    private ExperimentsSelectionViewModel viewModel;

    public void handleExperimentButtonAction(ActionEvent event) {
        logger.trace("Handling experiments button action");
    }

    public void handleLeaveEButtonAction(ActionEvent event) {
        logger.trace("Handling leave experiments button action");
        viewModel.leaveExperimentsSelection(event);
    }
}