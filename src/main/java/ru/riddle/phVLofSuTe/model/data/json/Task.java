package ru.riddle.phVLofSuTe.model.data.json;

import java.util.List;

public record Task(
        int id,
        String condition,
        List<String> vars,
        List<String> defvars,
        String given,
        String toFind,
        List<String> decision,
        String answer,
        String formulaAns,
        String resultAns,
        int level
){}
