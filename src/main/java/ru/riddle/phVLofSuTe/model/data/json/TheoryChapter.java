package ru.riddle.phVLofSuTe.model.data.json;

import java.util.List;

public record TheoryChapter(
        int id,
        String title,
        List<TheoryPage> pages
){}
