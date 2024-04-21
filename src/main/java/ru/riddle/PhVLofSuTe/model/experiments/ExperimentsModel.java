package ru.riddle.PhVLofSuTe.model.experiments;

import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
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
    private boolean isSecondAnimationAnimating = false;

    public void leaveExperiments(ActionEvent event){
        ModelUtil.changeScreen(event, FXMLs.MENU_TE_SELECTION);
    }

    public void leaveExperiment(ActionEvent event){
        ModelUtil.changeScreen(event, FXMLs.EXPERIMENTS_MENU);
    }

    public void openExperiment(ActionEvent event){
        String id = ((Node) (event.getSource())).getId();
        ModelUtil.changeScreen(event,
                switch (id){
                    case "FirstExperiment" -> FXMLs.firstExperiment.getFirst();
                    case "SecondExperiment" -> FXMLs.EXPERIMENTS_SECOND_1;
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

    public void startFirstExperiment(ImageView syringePiston, ImageView drop, Arc arcDrop, ImageView waterBucket){
        if(!isFirstAnimationAnimating) {
            TranslateTransition translate = new TranslateTransition();
            translate.setNode(syringePiston);
            translate.setDuration(Duration.seconds(15));
            translate.setByY(194);

            TranslateTransition transitionDrop = new TranslateTransition();
            transitionDrop.setNode(drop);
            transitionDrop.setDuration(Duration.millis(375));
            transitionDrop.setByY(82);
            transitionDrop.setCycleCount(40);

            TranslateTransition transitionArcDrop = new TranslateTransition();
            transitionArcDrop.setNode(arcDrop);
            transitionArcDrop.setDuration(Duration.millis(375));
            transitionArcDrop.setByY(3);
            transitionArcDrop.setCycleCount(40);

            ParallelTransition drippingTransition = new ParallelTransition(translate, transitionDrop, transitionArcDrop);

            drippingTransition.play();

            isFirstAnimationAnimating = true;

            translate.setOnFinished(event -> {
                TranslateTransition translate1 = new TranslateTransition();
                translate1.setNode(syringePiston);
                translate1.setDuration(Duration.seconds(5));
                translate1.setByY(-194);

                TranslateTransition waterBucketTransition1 = new TranslateTransition();
                waterBucketTransition1.setNode(waterBucket);
                waterBucketTransition1.setDuration(Duration.seconds(3));
                waterBucketTransition1.setByX(-250);

                TranslateTransition waterBucketTransition2 = new TranslateTransition();
                waterBucketTransition2.setNode(waterBucket);
                waterBucketTransition2.setDuration(Duration.seconds(1));
                waterBucketTransition2.setByY(-13);

                TranslateTransition waterBucketTransition3 = new TranslateTransition();
                waterBucketTransition3.setNode(waterBucket);
                waterBucketTransition3.setDuration(Duration.seconds(1));
                waterBucketTransition3.setByY(13);

                TranslateTransition waterBucketTransition4 = new TranslateTransition();
                waterBucketTransition4.setNode(waterBucket);
                waterBucketTransition4.setDuration(Duration.seconds(1));
                waterBucketTransition4.setByX(250);

                SequentialTransition refillingTransition = new SequentialTransition(
                        waterBucketTransition1,
                        waterBucketTransition2,
                        translate1,
                        waterBucketTransition3,
                        waterBucketTransition4
                );

                refillingTransition.play();

                isFirstAnimationAnimating = false;
            });

            transitionDrop.setOnFinished(event -> drop.setY(drop.getY() - 82));

            transitionArcDrop.setOnFinished(event -> arcDrop.setTranslateY(arcDrop.getTranslateY() - 3));
        }
    }

    public void startSecondExperiment(ImageView drop, Arc waterOnCoin){
        if(!isSecondAnimationAnimating){
            drop.setVisible(true);

            TranslateTransition dropTransition = new TranslateTransition();
            dropTransition.setNode(drop);
            dropTransition.setByY(275);
            dropTransition.setDuration(Duration.millis(500));


            ScaleTransition dropOCT = new ScaleTransition();
            dropOCT.setNode(drop);
            dropOCT.setFromX(1);
            dropOCT.setToX(1.5f);
            dropOCT.setFromY(1);
            dropOCT.setToY(0.3f);
            dropOCT.setDuration(Duration.millis(250));

            dropOCT.setOnFinished(event -> {
                waterOnCoin.setScaleY(waterOnCoin.getScaleY() * 1.17);
                waterOnCoin.setScaleX(waterOnCoin.getScaleX() * 1.5);

                if(waterOnCoin.getScaleX() > 10){
                    waterOnCoin.setScaleX(10);
                }
            });

            SequentialTransition dropSequential = new SequentialTransition(dropTransition, dropOCT);
            dropSequential.setCycleCount(10);

            waterOnCoin.setRadiusX(10);
            waterOnCoin.setRadiusY(10);

            dropSequential.play();
            isSecondAnimationAnimating = true;
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
