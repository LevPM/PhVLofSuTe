package ru.riddle.phVLofSuTe.view.theory.examples;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import ru.riddle.phVLofSuTe.viewModel.theory.examples.BasicTextCellViewModel;

import java.net.URL;
import java.util.ResourceBundle;

public class BasicTextCellView implements FxmlView<BasicTextCellViewModel>, Initializable {

    private static final Logger logger = LoggerFactory.getLogger(BasicTextCellView.class);

    @FXML
    private Label text;

    @InjectViewModel
    private BasicTextCellViewModel viewModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logger.debug("Initializing...");
        this.text.textProperty().bind(viewModel.textProperty());
    }
}