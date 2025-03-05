package ru.riddle.phVLofSuTe.view.tasks;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import ru.riddle.phVLofSuTe.viewModel.tasks.GeneratedTasksPaginationViewModel;

import java.net.URL;
import java.util.ResourceBundle;

public class GeneratedTasksPaginationView implements FxmlView<GeneratedTasksPaginationViewModel>, Initializable {

    private static final Logger logger = LoggerFactory.getLogger(GeneratedTasksPaginationView.class);

    @FXML
    private Button previousButton;

    @FXML
    private Button nextButton;

    @FXML
    private Label title;

    @FXML
    private Pagination pagination;

    @InjectViewModel
    private GeneratedTasksPaginationViewModel viewModel;

    public void handlePreviousButtonAction(ActionEvent event) {
        logger.trace("Handling PreviousButtonAction");
        viewModel.backToPreviousScreen();
    }

    public void handleNextButtonAction(ActionEvent event) {
        logger.trace("Handling NextButtonAction");
        viewModel.goToNextScreen();
    }

    public void handleCompleteButtonAction(ActionEvent event) {
        logger.trace("Handling CompleteButtonAction");
        viewModel.completeWork(event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logger.trace("Initializing...");
        pagination.currentPageIndexProperty().bindBidirectional(viewModel.currentPageIndexProperty());
        pagination.pageCountProperty().bind(viewModel.pageCountProperty());
        pagination.pageFactoryProperty().bind(viewModel.pageFactoryProperty());

        previousButton.disableProperty().bind(viewModel.previousButtonDisableProperty());
        nextButton.disableProperty().bind(viewModel.nextButtonDisableProperty());

        title.textProperty().bind(viewModel.titleLabelProperty());
    }
}