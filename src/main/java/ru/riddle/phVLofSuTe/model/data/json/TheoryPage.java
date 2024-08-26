package ru.riddle.phVLofSuTe.model.data.json;

import java.util.List;

public record TheoryPage(
        int id,
        String title,
        List<String> text
){}
