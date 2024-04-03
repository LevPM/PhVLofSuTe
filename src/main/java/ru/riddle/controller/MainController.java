package ru.riddle.controller;

import ru.riddle.model.MainScreenModel;
public class MainController{

    private final MainScreenModel model;

    public MainController(){
        model = new MainScreenModel();
    }

    public void handleSettingButtonAction(){
        model.printOpened();
    }
}
