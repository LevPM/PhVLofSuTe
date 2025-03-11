package ru.riddle.phVLofSuTe.model.tasks;

import org.mariuszgromada.math.mxparser.Expression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.riddle.phVLofSuTe.model.data.json.JSONDataManager;
import ru.riddle.phVLofSuTe.model.data.json.Task;
import ru.riddle.phVLofSuTe.model.data.json.TaskInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class TasksGenerator {


    private static final Logger logger = LoggerFactory.getLogger(TasksGenerator.class);

    private static Task generateTask(){
        logger.debug("Generating task...");
        Task task = JSONDataManager.getById((int)(Math.random() * Objects.requireNonNull(JSONDataManager.getListOf(TaskInfo.class)).size()) + 1, Task.class);
        String condition = Objects.requireNonNull(task).condition();
        List<Variable> variables = parseVars(task.vars());
        String formulaAns = task.formulaAns();
        for(Variable variable: variables){
            Random r = new Random();
            double rangeMin = variable.valueFrom;
            double rangeMax = variable.valueTo;
            double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
            randomValue = (double) Math.round(randomValue * Math.pow(10, variable.scale)) / Math.pow(10, variable.scale);

            condition = condition.replace(variable.name, randomValue + " " + variable.unit);
            formulaAns = formulaAns.replace(variable.name, Double.toString(randomValue));
        }
        Expression expression = new Expression(formulaAns.substring(0, formulaAns.indexOf(" ")));
        int formulaScale = Integer.parseInt(formulaAns.substring(formulaAns.indexOf("@") + 1));
        double resultAns = (double) Math.round(expression.calculate() * Math.pow(10, formulaScale)) / Math.pow(10, formulaScale);
        condition = condition.replace("p^1", Integer.toString(formulaScale));
        logger.debug("Task with id {} is generated", task.id());
        return new Task(task.id(), condition, task.vars(), task.defvars(), task.given(), task.toFind(), task.decision(), task.answer(), task.formulaAns(), Double.toString(resultAns), task.level());
    }

    public static Task createDefaultTask(int id){
        logger.debug("Creating default task with id: {}", id);
        Task task = JSONDataManager.getById(id, Task.class);
        String condition = Objects.requireNonNull(task).condition();
        List<DefVariable> defVariables = parseDefVars(task.defvars());
        for(DefVariable defVariable: defVariables){
            condition = condition.replace(defVariable.name, defVariable.value);
        }
        logger.debug("Default task with id {} is generated", id);
        return new Task(task.id(), condition, task.vars(), task.defvars(), task.given(), task.toFind(), task.decision(), task.answer(), task.formulaAns(), task.resultAns(), task.level());
    }

    public static List<Task> generateTasks(int count){
        logger.debug("Generating {} tasks", count);
        List<Task> result = new ArrayList<>();
        for(int i = 0; i < count; i++){
            result.add(generateTask());
        }
        return result;
    }

    private static DefVariable parseDefVar(String defVariable){
        logger.trace("Parsing default variable: {}", defVariable);
        return new DefVariable(
                defVariable.substring(0, 1),
                defVariable.substring(2)
        );
    }

    private static List<DefVariable> parseDefVars(List<String> defVariables){
        return defVariables.stream().map(TasksGenerator::parseDefVar).toList();
    }

    private static Variable parseVar(String variable){
        logger.trace("Parsing variable: {}", variable);
        return new Variable(
                variable.substring(0, 1),
                Double.parseDouble(variable.substring(2, variable.indexOf("-"))),
                Double.parseDouble(variable.substring(variable.indexOf("-") + 1, variable.indexOf(" "))),
                variable.substring(variable.indexOf(" ") + 1, variable.indexOf("+")),
                Integer.parseInt(variable.substring(variable.indexOf("+") + 1))
        );
    }

    private static List<Variable> parseVars(List<String> variables){
        return variables.stream().map(TasksGenerator::parseVar).toList();
    }

    private record Variable(
            String name,
            double valueFrom,
            double valueTo,
            String unit,
            int scale
    ){}

    private record DefVariable(
            String name,
            String value
    ){}
}
