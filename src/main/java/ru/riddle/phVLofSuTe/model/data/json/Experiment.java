package ru.riddle.phVLofSuTe.model.data.json;

import java.util.List;

public record Experiment(
        int id,
        boolean isStandard,
        String title,
        List<String> text,
        List<String> experimentText,
        List<String> Conclusion
) {}
