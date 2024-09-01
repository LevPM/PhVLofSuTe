package ru.riddle.phVLofSuTe.model.data.json.liquid;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javafx.scene.paint.Color;

@JsonDeserialize(using = LiquidDeserializer.class)
public record Liquid(
        String id,
        String name,
        Color color,
        int amountOfDrops
){}
