package ru.riddle.PhVLofSuTe.model.experiments;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Arc;
import javafx.util.Duration;
import ru.riddle.PhVLofSuTe.model.util.FXMLs;
import ru.riddle.PhVLofSuTe.model.util.ModelUtil;

public class ExperimentsModel {

    private boolean isFirstAnimationAnimating = false;

    public void leaveExperiments(ActionEvent event){
        ModelUtil.changeScreen(event, FXMLs.MENU_TE_SELECTION);
    }

    public void openExperiment(ActionEvent event){
        String id = ((Node) (event.getSource())).getId();
        ModelUtil.changeScreen(event,
                switch (id){
                    case "FirstExperiment" -> FXMLs.firstExperiment.getFirst();
                    default -> throw new IllegalStateException("Unexpected value: " + id);
                }
        );
    }

    public void backToPreviousScreen(ActionEvent event) {
        String id = ((Node) event.getSource()).getScene().getRoot().getId();

        final int numberOfPreviousFXML = Integer.parseInt(id.substring(id.length() - 1)) - 2;
        ModelUtil.changeScreen(event,
                switch (id.substring(0, id.length() - 1)){
                    case "FirstExperiment" -> FXMLs.firstExperiment.get(numberOfPreviousFXML);
                    default -> throw new IllegalStateException("Unexpected value: " + id);
                }
        );
    }

    public void goToNextScreen(ActionEvent event) {
        String id = ((Node) event.getSource()).getScene().getRoot().getId();

        final int numberOfNextFXML = Integer.parseInt(id.substring(id.length() - 1));
        ModelUtil.changeScreen(event,
                switch (id.substring(0, id.length() - 1)){
                    case "FirstExperiment" -> FXMLs.firstExperiment.get(numberOfNextFXML);
                    default -> throw new IllegalStateException("Unexpected value: " + id);
                }
        );
    }

    public void startFirstExperiment(ImageView syringePiston, ImageView drop, Arc acrDrop){
        if(!isFirstAnimationAnimating) {
            TranslateTransition translate = new TranslateTransition();
            translate.setNode(syringePiston);
            translate.setDuration(Duration.seconds(10));
            translate.setByY(194);

            TranslateTransition transitionDrop = new TranslateTransition();
            transitionDrop.setNode(drop);
            transitionDrop.setDuration(Duration.millis(250));
            transitionDrop.setByY(82);
            transitionDrop.setCycleCount(40);

            TranslateTransition transitionArcDrop = new TranslateTransition();
            transitionArcDrop.setNode(acrDrop);
            transitionArcDrop.setDuration(Duration.millis(250));
            transitionArcDrop.setByY(5);
            transitionArcDrop.setCycleCount(40);

            translate.play();
            transitionArcDrop.play();
            transitionDrop.play();

            isFirstAnimationAnimating = true;

            translate.setOnFinished(event -> {
                syringePiston.setY(syringePiston.getY() - 194);
                isFirstAnimationAnimating = false;
            });
        }
    }

    public void showDropCount(Button countHider){
        countHider.setVisible(false);
        countHider.setDisable(true);
    }

    public void hideDropCount(Button countHider){
        countHider.setDisable(false);
        countHider.setVisible(true);
    }
}
