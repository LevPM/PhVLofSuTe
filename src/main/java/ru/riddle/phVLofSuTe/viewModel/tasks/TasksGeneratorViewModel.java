package ru.riddle.phVLofSuTe.viewModel.tasks;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.ViewModel;
import ru.riddle.phVLofSuTe.model.view.ViewManager;
import ru.riddle.phVLofSuTe.model.view.ViewName;

public class TasksGeneratorViewModel implements ViewModel {

    private static final Logger logger = LoggerFactory.getLogger(TasksGeneratorViewModel.class);


    ObservableList<String> StubThemesList = FXCollections.observableArrayList(
            "Поверхностные эффекты",
            "Поверхностное натяжение",
            "Поверхностная энергия",
            "Жидкостные плёнки",
            "Зависимость поверхностного натяжения от температуры",
            "Смачивание и несмачивание",
            "Расположение молекул у поверхности тел",
            "Давление под искривлённой поверхностью жидкости",
            "Капиллярные явления",
            "Высота поднятия жидкости в капиллярных трубках",
            "Адсорбция",
            "Флотация",
            "Молекулярная картина поверхностного слоя",
            "Строение жидкостей"
    );

    public void leaveExperimentsSelection(ActionEvent event){
        logger.debug("Leaving experiments selection");
        ViewManager.changeScreen(event, ViewName.MENU);
    }

    public ObservableList<String> stubThemesListProperty() {
        return StubThemesList;
    }

    public void createTasks(ActionEvent event){
        logger.debug("Creating tasks...");
        ViewManager.changeScreen(event, ViewName.TASKS_GENERATED);
    }
}