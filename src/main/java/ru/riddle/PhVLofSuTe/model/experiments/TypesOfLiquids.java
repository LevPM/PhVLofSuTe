package ru.riddle.PhVLofSuTe.model.experiments;

import javafx.scene.paint.Color;

public enum TypesOfLiquids {

    WATER("Вода", Color.AQUA, 40),
    SOAP_WATER("Мыльная вода", Color.PALETURQUOISE, 110),
    ;

    private final String name;
    private final Color color;
    private final int amountOfDrops;

    TypesOfLiquids(String name, Color color, int amountOfDrops){ // Amount of drops -> for third experiment,
        this.name = name;
        this.color = color;
        this.amountOfDrops = amountOfDrops;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public int getAmountOfDrops() {
        return amountOfDrops;
    }
}
