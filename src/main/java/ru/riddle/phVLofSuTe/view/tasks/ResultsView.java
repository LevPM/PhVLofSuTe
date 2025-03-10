package ru.riddle.phVLofSuTe.view.tasks;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import ru.riddle.phVLofSuTe.viewModel.tasks.ResultsViewModel;

public class ResultsView implements FxmlView<ResultsViewModel> {

    private static final Logger logger = LoggerFactory.getLogger(ResultsView.class);

    @FXML
    private Label resultsLabel;

    @FXML
    private ListView resultsList;

    @InjectViewModel
    private ResultsViewModel viewModel;


    public void handeBackButtonAction(ActionEvent event) {
        logger.debug("Handling Back Button Action");

    }
}