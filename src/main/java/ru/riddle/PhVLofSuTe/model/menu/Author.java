package ru.riddle.PhVLofSuTe.model.menu;

public record Author(String name, String nickname, String position) {

    @Override
    public String toString(){
        return name + " (" + nickname + ")" + " - " + position;
    }
}
