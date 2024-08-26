package ru.riddle.phVLofSuTe.model.data.json;

import java.util.List;

public record Example(
        int id,
        String condition,
        String given,
        String toFind,
        List<String> decision,
        String answer
){}
