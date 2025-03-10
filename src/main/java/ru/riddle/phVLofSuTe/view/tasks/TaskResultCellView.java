package ru.riddle.phVLofSuTe.view.tasks;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import ru.riddle.phVLofSuTe.viewModel.tasks.TaskResultCellViewModel;

import java.net.URL;
import java.util.ResourceBundle;

public class TaskResultCellView implements FxmlView<TaskResultCellViewModel>, Initializable {

    private static final Logger logger = LoggerFactory.getLogger(TaskResultCellView.class);

    @FXML
    private Label taskNumber;

    @FXML
    private Label rightAnswer;

    @FXML
    private Label yourAnswer;

    @InjectViewModel
    private TaskResultCellViewModel viewModel;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logger.debug("Initializing...");
        taskNumber.textProperty().bind(viewModel.taskNumberProperty());
        rightAnswer.textProperty().bind(viewModel.rightAnswerProperty());
        yourAnswer.textProperty().bind(viewModel.yourAnswerProperty());
    }
}