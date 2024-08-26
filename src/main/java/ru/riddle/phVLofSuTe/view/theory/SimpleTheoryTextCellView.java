package ru.riddle.phVLofSuTe.view.theory;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import ru.riddle.phVLofSuTe.viewModel.theory.SimpleTheoryTextCellViewModel;

import java.net.URL;
import java.util.ResourceBundle;

public class SimpleTheoryTextCellView implements FxmlView<SimpleTheoryTextCellViewModel>, Initializable {

    private static final Logger logger = LoggerFactory.getLogger(SimpleTheoryTextCellView.class);

    @FXML
    private Label text;

    @InjectViewModel
    private SimpleTheoryTextCellViewModel viewModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logger.debug("Initializing...");
        this.text.textProperty().bind(viewModel.textProperty());
    }
}