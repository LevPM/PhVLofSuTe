package ru.riddle.phVLofSuTe.view.tasks;

import de.saxsys.mvvmfx.utils.viewlist.CachedViewModelCellFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import ru.riddle.phVLofSuTe.viewModel.tasks.ResultsViewModel;
import ru.riddle.phVLofSuTe.viewModel.tasks.TaskResultCellViewModel;

import java.net.URL;
import java.util.ResourceBundle;

public class ResultsView implements FxmlView<ResultsViewModel>, Initializable {

    private static final Logger logger = LoggerFactory.getLogger(ResultsView.class);

    @FXML
    private Label resultsLabel;

    @FXML
    private ListView<TaskResultCellViewModel> resultsList;

    @InjectViewModel
    private ResultsViewModel viewModel;


    public void handeBackButtonAction(ActionEvent event) {
        logger.debug("Handling Back Button Action");
        viewModel.backToGeneratorView(event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logger.debug("Initializing...");
        resultsList.setItems(viewModel.resultsProperty());
        resultsList.setCellFactory(CachedViewModelCellFactory.createForFxmlView(TaskResultCellView.class));
        resultsLabel.textProperty().bind(viewModel.resultTextProperty());
    }
}