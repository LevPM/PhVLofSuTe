package ru.riddle.phVLofSuTe.viewModel.tasks;

import de.saxsys.mvvmfx.Initialize;
import de.saxsys.mvvmfx.InjectScope;
import javafx.event.ActionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.riddle.phVLofSuTe.model.Triple;
import ru.riddle.phVLofSuTe.model.view.ViewManager;
import ru.riddle.phVLofSuTe.model.view.ViewName;
import ru.riddle.phVLofSuTe.view.tasks.GeneratedTaskView;
import ru.riddle.phVLofSuTe.viewModel.SimpleTextPaginationViewModel;

import java.util.HashMap;
import java.util.Map;

public class GeneratedTasksPaginationViewModel extends SimpleTextPaginationViewModel {

    private static final Logger logger = LoggerFactory.getLogger(GeneratedTasksPaginationViewModel.class);

    @InjectScope
    private GeneratorInfoScope generatorInfo;

    private Map<Integer, Triple<String, String, String>> answers;

    @Override
    public void backToMenu(ActionEvent event) {
        logger.debug("Backing to generator settings");
        ViewManager.changeScreen(event, ViewName.TASKS_GENERATOR);
    }

    public void completeWork(ActionEvent event) {
        logger.debug("Completing work...");
        if(answers.size() != generatorInfo.generatedTasksProperty().size()){
            for(int i = 0; i < generatorInfo.generatedTasksProperty().size(); i ++){
                if(!answers.containsKey(i)){
                    answers.put(
                            i,
                            new Triple<>(
                                    Integer.toString(i + 1),
                                    generatorInfo.generatedTasksProperty().get(i).resultAns(),
                                    "-"
                                    )
                    );
                }
            }
        }
        ViewManager.changeScreen(event, ViewName.TASKS_RESULTS, new ResultsScope(answers.values().stream().toList()));
    }

    @Initialize
    protected void initialize(){
        super.initialize();
        answers = new HashMap<>(10);
        pageCountProperty().set(generatorInfo.generatedTasksProperty().get().size());
        pageFactoryProperty().set((pageIndex)-> {
            titleLabelProperty().set("Задание №" + (pageIndex + 1));
            GeneratedTaskDataScope generatedTaskDataScope = new GeneratedTaskDataScope(
                    generatorInfo.generatedTasksProperty().get(pageIndex).level(),
                    generatorInfo.generatedTasksProperty().get(pageIndex).condition()
            );
            generatedTaskDataScope
                    .answerProperty()
                    .addListener(
                            event ->
                                    answers.put(
                                            pageIndex,
                                            new Triple<>(
                                                    Integer.toString(pageIndex + 1),
                                                    generatorInfo.generatedTasksProperty().get(pageIndex).resultAns(),
                                                    generatedTaskDataScope.answerProperty().get()
                                            )
                                    )
                    );
            return new GeneratedTaskView(generatedTaskDataScope);
            });
    }
}