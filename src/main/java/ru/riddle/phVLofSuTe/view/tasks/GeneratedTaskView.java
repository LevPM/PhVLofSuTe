package ru.riddle.phVLofSuTe.view.tasks;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import ru.riddle.phVLofSuTe.model.view.ViewManager;
import ru.riddle.phVLofSuTe.viewModel.tasks.GeneratedTaskDataScope;
import ru.riddle.phVLofSuTe.viewModel.tasks.GeneratedTaskViewModel;

import java.net.URL;
import java.util.ResourceBundle;

public class GeneratedTaskView extends VBox implements FxmlView<GeneratedTaskViewModel>, Initializable {

    private static final Logger logger = LoggerFactory.getLogger(GeneratedTaskView.class);

    @FXML
    private Label level;

    @FXML
    private Label condition;

    @FXML
    private TextField answer;

    @FXML
    private Button answerSaveButton;

    @InjectViewModel
    private GeneratedTaskViewModel viewModel;

    public GeneratedTaskView(GeneratedTaskDataScope scope){
        ViewManager.downloadCustomComponent(this, GeneratedTaskView.class, scope);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logger.debug("Initializing...");
        condition.textProperty().bind(viewModel.conditionProperty());
        level.textProperty().bind(viewModel.levelProperty());
    }
}