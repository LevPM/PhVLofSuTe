package ru.riddle.phVLofSuTe.view.tasks;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import ru.riddle.phVLofSuTe.viewModel.tasks.TasksGeneratorViewModel;

import java.net.URL;
import java.util.ResourceBundle;

public class TasksGeneratorView implements FxmlView<TasksGeneratorViewModel>, Initializable {

    private static final Logger logger = LoggerFactory.getLogger(TasksGeneratorView.class);

    @InjectViewModel
    private TasksGeneratorViewModel viewModel;

    @FXML
    private ListView<String> themesList;

    public void handleLeaveEButtonAction(ActionEvent event) {
        logger.trace("Handling leave experiments button action");
        viewModel.leaveExperimentsSelection(event);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logger.debug("Initializing");
        themesList.setItems(viewModel.themesListProperty());
    }

    public void handleCreateButtonAction(ActionEvent event) {
        logger.debug("Handling CreateButtonAction");
        viewModel.createTasks(event);
    }
}