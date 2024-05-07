package ru.riddle.phVLofSuTe.model.experiments;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Syringe extends AnchorPane{

    @FXML
    private AnchorPane syringe;

    @FXML
    private Group syringePart;

    private int countOfParts = 6; //default count of parts = 6

    public Syringe(){
        loadFXML();
    }

    public Syringe(int countOfParts){
        this();
        this.countOfParts = countOfParts;
    }

    private void loadFXML(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/experiments/syringe/syringeFXML.fxml"));
        loader.setRoot(this);

        try{
            loader.load();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    private void buildSyringe(){
        for(int i = countOfParts; i > 0; i--){

        }
    }
}
