package ru.riddle.phVLofSuTe.model.tasks;

import ru.riddle.phVLofSuTe.model.data.json.JSONDataManager;
import ru.riddle.phVLofSuTe.model.data.json.Task;
import ru.riddle.phVLofSuTe.viewModel.tasks.GeneratedTaskDataScope;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class TasksGenerator {

    private GeneratedTaskDataScope generateTask(){
        Task task = JSONDataManager.getById((int)(Math.random() * 5) + 1, Task.class);
        String condition = Objects.requireNonNull(task).condition();
        List<String> vars = task.vars();
        List<Variable> variables = parseVars(vars);
        for(Variable variable: variables){
            Random r = new Random();
            double rangeMin = variable.valueFrom;
            double rangeMax = variable.valueTo;
            double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();

            condition = condition.replace(variable.name, Double.toString(randomValue));
        }
        return new GeneratedTaskDataScope(task.level(), condition);
    }

    public List<GeneratedTaskDataScope> generateTasks(int count){
        List<GeneratedTaskDataScope> result = new ArrayList<>();
        for(int i = 0; i < count; i++){
            result.add(generateTask());
        }
        return result;
    }

    private Variable parseVar(String variable){
        return new Variable(
                variable.substring(0, 1),
                Double.parseDouble(variable.substring(2, variable.indexOf("-"))),
                Double.parseDouble(variable.substring(variable.indexOf("-") + 1, variable.indexOf(" "))),
                variable.substring(variable.indexOf(" ") + 1)
        );
    }

    private List<Variable> parseVars(List<String> variables){
        return variables.stream().map(this::parseVar).toList();
    }

    record Variable(
            String name,
            double valueFrom,
            double valueTo,
            String unit
    ){}
}
