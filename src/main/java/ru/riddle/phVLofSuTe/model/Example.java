package ru.riddle.phVLofSuTe.model;

import java.util.List;

public record Example(
        int id,
        String condition,
        String given,
        String toFind,
        List<String> decision,
        String answer
){}
