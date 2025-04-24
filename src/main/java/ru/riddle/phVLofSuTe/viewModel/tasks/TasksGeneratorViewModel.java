package ru.riddle.phVLofSuTe.viewModel.tasks;

import de.saxsys.mvvmfx.Initialize;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.ViewModel;
import ru.riddle.phVLofSuTe.model.data.json.JSONDataManager;
import ru.riddle.phVLofSuTe.model.data.json.TheoryChapterInfo;
import ru.riddle.phVLofSuTe.model.tasks.TasksGenerator;
import ru.riddle.phVLofSuTe.model.view.ViewManager;
import ru.riddle.phVLofSuTe.model.view.ViewName;
import java.util.Objects;

public class TasksGeneratorViewModel implements ViewModel {

    private static final Logger logger = LoggerFactory.getLogger(TasksGeneratorViewModel.class);

    private final ObservableList<String> themesList = FXCollections.observableArrayList();

    private final DoubleProperty countOfTasks = new SimpleDoubleProperty();
    private final DoubleProperty levelOfTasks = new SimpleDoubleProperty();

    public void leaveExperimentsSelection(ActionEvent event){
        logger.debug("Leaving experiments selection");
        ViewManager.changeScreen(event, ViewName.MENU);
    }

    public DoubleProperty countOfTasksProperty(){
        return countOfTasks;
    }

    public  DoubleProperty levelOfTasksProperty(){
        return levelOfTasks;
    }

    public ObservableList<String> themesListProperty() {
        return themesList;
    }

    public void createTasks(ActionEvent event){
        logger.debug("Creating {} tasks", countOfTasks.get());
        ViewManager.changeScreen(event, ViewName.TASKS_PAGINATION, new GeneratorInfoScope(TasksGenerator.generateTasks((int) countOfTasks.get(), (int) levelOfTasks.get())));
    }

    @Initialize
    private void initialize(){
        logger.debug("Initializing...");
        themesList.addAll(Objects.requireNonNull(JSONDataManager.getListOf(TheoryChapterInfo.class)).stream().filter(TheoryChapterInfo::hasTasks).map(TheoryChapterInfo::title).toList());
    }
}