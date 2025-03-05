package ru.riddle.phVLofSuTe.model.data.json;

import java.util.List;

public record Task(
        int id,
        String condition,
        String given,
        String toFind,
        List<String> decision,
        String answer,
        int level
){}
