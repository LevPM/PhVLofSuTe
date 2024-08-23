package ru.riddle.phVLofSuTe.view.theory;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.image.ImageView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import ru.riddle.phVLofSuTe.viewModel.theory.BasicTheoryPaginationViewModel;

import java.net.URL;
import java.util.ResourceBundle;

public class BasicTheoryPaginationView implements FxmlView<BasicTheoryPaginationViewModel>, Initializable {

    private static final Logger logger = LoggerFactory.getLogger(BasicTheoryPaginationView.class);

    @FXML
    private Button previousButton;

    @FXML
    private Button nextButton;

    @FXML
    private Label exampleNumberLabel;

    @FXML
    private ImageView exampleImage;

    @FXML
    private Pagination pagination;

    @InjectViewModel
    private BasicTheoryPaginationViewModel viewModel;

    public void handlePreviousButtonAction(ActionEvent event) {
        logger.trace("Handling PreviousButtonAction");
        viewModel.backToPreviousScreen();
    }

    public void handleBackButtonAction(ActionEvent event) {
        logger.trace("Handling BackButtonAction");
        viewModel.backToTheoryExamplesSelection(event);
    }

    public void handleNextButtonAction(ActionEvent event) {
        logger.trace("Handling NextButtonAction");
        viewModel.goToNextScreen();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logger.trace("Initializing...");
        pagination.currentPageIndexProperty().bindBidirectional(viewModel.currentPageIndexProperty());
        pagination.pageCountProperty().bind(viewModel.pageCountProperty());
        pagination.pageFactoryProperty().bind(viewModel.pageFactoryProperty());

        previousButton.disableProperty().bind(viewModel.previousButtonDisableProperty());
        nextButton.disableProperty().bind(viewModel.nextButtonDisableProperty());

        exampleImage.imageProperty().bind(viewModel.exampleImageProperty());

        exampleNumberLabel.textProperty().bind(viewModel.exampleNumberLabelProperty());
    }
}