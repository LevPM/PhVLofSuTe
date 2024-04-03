package ru.riddle.view.settings;

import javafx.scene.Parent;

public class Setting {
    private final String name;
    private final Parent setting;

    public Setting(String name, Parent setting){
        this.name = name;
        this.setting = setting;
    }
}
