package ru.riddle.phVLofSuTe.viewModel.tasks;

import de.saxsys.mvvmfx.Initialize;
import de.saxsys.mvvmfx.InjectScope;
import javafx.event.ActionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.riddle.phVLofSuTe.model.view.ViewManager;
import ru.riddle.phVLofSuTe.model.view.ViewName;
import ru.riddle.phVLofSuTe.view.tasks.GeneratedTaskView;
import ru.riddle.phVLofSuTe.viewModel.SimpleTextPaginationViewModel;

public class GeneratedTasksPaginationViewModel extends SimpleTextPaginationViewModel {

    private static final Logger logger = LoggerFactory.getLogger(GeneratedTasksPaginationViewModel.class);

    @InjectScope
    private GeneratorInfoScope generatorInfo;

    @Override
    public void backToMenu(ActionEvent event) {
        logger.debug("Backing to generator settings");
        ViewManager.changeScreen(event, ViewName.TASKS_GENERATOR);
    }

    public void completeWork(ActionEvent event) {

    }

    @Initialize
    protected void initialize(){
        super.initialize();
        pageCountProperty().set(generatorInfo.generatedTasksProperty().get().size());
        pageFactoryProperty().set((pageIndex)-> {
            titleLabelProperty().set("Задание №" + (pageIndex + 1));
            return new GeneratedTaskView(
                    new GeneratedTaskDataScope(
                            generatorInfo.generatedTasksProperty().get(pageIndex).level(),
                            generatorInfo.generatedTasksProperty().get(pageIndex).condition()
                    ));
            });
    }
}