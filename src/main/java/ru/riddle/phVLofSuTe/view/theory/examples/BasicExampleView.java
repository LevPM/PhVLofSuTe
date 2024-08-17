package ru.riddle.phVLofSuTe.view.theory.examples;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.image.ImageView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import ru.riddle.phVLofSuTe.viewModel.theory.examples.BasicExampleViewModel;

import java.net.URL;
import java.util.ResourceBundle;

public class BasicExampleView implements FxmlView<BasicExampleViewModel>, Initializable {

    private static final Logger logger = LoggerFactory.getLogger(BasicExampleView.class);

    @FXML
    private Label exampleNumberLabel;

    @FXML
    private ImageView exampleImage;

    @FXML
    private Pagination pagination;

    @InjectViewModel
    private BasicExampleViewModel viewModel;

    public void handlePreviousButtonAction(ActionEvent event) {

    }

    public void handleBackButtonAction(ActionEvent event) {

    }

    public void handleNextButtonAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pagination.currentPageIndexProperty().bindBidirectional(viewModel.currentPageIndexProperty());
        pagination.pageCountProperty().bind(viewModel.pageCountProperty());
        pagination.pageFactoryProperty().bind(viewModel.pageFactoryProperty());
    }
}