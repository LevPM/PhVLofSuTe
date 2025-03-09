package ru.riddle.phVLofSuTe.model.tasks;

import ru.riddle.phVLofSuTe.model.data.json.JSONDataManager;
import ru.riddle.phVLofSuTe.model.data.json.Task;
import ru.riddle.phVLofSuTe.viewModel.tasks.GeneratedTaskDataScope;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TasksGenerator {

    private GeneratedTaskDataScope generateTask(){
        Task task = JSONDataManager.getById((int)(Math.random() * 5) + 1, Task.class);
        String condition = Objects.requireNonNull(task).condition();
        String resCondition = condition;
        List<String> vars = task.vars();
        return null;
    }

    public List<GeneratedTaskDataScope> generateTasks(int count){
        List<GeneratedTaskDataScope> result = new ArrayList<>();
        for(int i = 0; i < count; i++){
            result.add(generateTask());
        }
        return result;
    }
}
