package ru.riddle.phVLofSuTe.viewModel.tasks;

import de.saxsys.mvvmfx.Initialize;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.ViewModel;
import ru.riddle.phVLofSuTe.model.data.json.JSONDataManager;
import ru.riddle.phVLofSuTe.model.data.json.TheoryChapterInfo;
import ru.riddle.phVLofSuTe.model.view.ViewManager;
import ru.riddle.phVLofSuTe.model.view.ViewName;

import java.util.Objects;

public class TasksGeneratorViewModel implements ViewModel {

    private static final Logger logger = LoggerFactory.getLogger(TasksGeneratorViewModel.class);


    ObservableList<String> themesList = FXCollections.observableArrayList();

    public void leaveExperimentsSelection(ActionEvent event){
        logger.debug("Leaving experiments selection");
        ViewManager.changeScreen(event, ViewName.MENU);
    }

    public ObservableList<String> themesListProperty() {
        return themesList;
    }

    public void createTasks(ActionEvent event){
        logger.debug("Creating tasks...");
        ViewManager.changeScreen(event, ViewName.TASKS_GENERATED);
    }

    @Initialize
    private void initialize(){
        logger.debug("Initializing...");
        themesList.addAll(Objects.requireNonNull(JSONDataManager.getListOf(TheoryChapterInfo.class)).stream().map(TheoryChapterInfo::title).toList());
    }
}