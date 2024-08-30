package ru.riddle.phVLofSuTe.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import ru.riddle.phVLofSuTe.viewModel.SimpleTextCellViewModel;

import java.net.URL;
import java.util.ResourceBundle;

public class SimpleTextCellView implements FxmlView<SimpleTextCellViewModel>, Initializable {

    private static final Logger logger = LoggerFactory.getLogger(SimpleTextCellView.class);

    @FXML
    private Label text;

    @InjectViewModel
    private SimpleTextCellViewModel viewModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logger.debug("Initializing...");
        this.text.textProperty().bind(viewModel.textProperty());
    }
}