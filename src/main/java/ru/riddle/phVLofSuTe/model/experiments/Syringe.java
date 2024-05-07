package ru.riddle.phVLofSuTe.model.experiments;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Syringe extends AnchorPane{

    @FXML
    private AnchorPane syringe;

    public Syringe(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/experiments/syringe/syringeFXML.fxml"));
        loader.setRoot(this);
        loader.setController(this);

        try{
            loader.load();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
