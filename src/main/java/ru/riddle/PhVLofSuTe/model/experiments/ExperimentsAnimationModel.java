package ru.riddle.PhVLofSuTe.model.experiments;

import javafx.animation.*;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.List;

public class ExperimentsAnimationModel {

    private boolean isFirstAnimationAnimating, isSecondAnimationAnimating, isThirdAnimationAnimating = false;

    public void animateFirstExperiment(AnchorPane firstExperimentSyringe){
        if(!isFirstAnimationAnimating){
            isFirstAnimationAnimating = true;
            Transition firstTransition = getTransitionForSyringe(firstExperimentSyringe);
            firstTransition.setOnFinished(event -> isFirstAnimationAnimating = false);
            firstTransition.play();
        }
    }

    public void animateSecondExperiment(ImageView drop, Arc waterOnCoin){
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

    public void animateThirdExperiment(AnchorPane waterPane, AnchorPane soapWaterPane){
        if(!isThirdAnimationAnimating){
            isThirdAnimationAnimating = true;
            ParallelTransition thirdAnimation = new ParallelTransition(getTransitionForSyringe(waterPane), getTransitionForSyringe(soapWaterPane));
            thirdAnimation.setOnFinished(event -> isThirdAnimationAnimating = false);
            thirdAnimation.play();
        }
    }

    private Transition getTransitionForSyringe(AnchorPane waterPane){

        List<Node> paneChildren = waterPane.getChildren();

        ImageView syringePiston = (ImageView) paneChildren.get(3);
        ImageView drop = (ImageView) paneChildren.get(1);
        Arc arcDrop = (Arc) paneChildren.get(0);
        ImageView waterBucket = (ImageView) paneChildren.get(6);

        Rectangle liquid = (Rectangle) paneChildren.get(2);
        liquid.setFill(
                switch (liquid.getId()){
                    case "soap_water" -> TypesOfLiquids.SOAP_WATER.getColor();
                    case "water" -> TypesOfLiquids.WATER.getColor();
                    default -> throw new IllegalStateException("Unexpected value: " + liquid.getId());
                }
        );

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

        transitionDrop.setOnFinished(event -> drop.setY(drop.getY() - 82));
        transitionArcDrop.setOnFinished(event -> arcDrop.setTranslateY(arcDrop.getTranslateY() - 3));

        return new SequentialTransition(getSyringeRefillingTransition(syringePiston, waterBucket), drippingTransition);
    }

    private Transition getSyringeRefillingTransition(ImageView syringePiston, ImageView waterBucket){
        TranslateTransition translate1 = new TranslateTransition();
        translate1.setNode(syringePiston);
        translate1.setDuration(Duration.seconds(5));
        translate1.setByY(-194);

        TranslateTransition waterBucketTransition1 = new TranslateTransition();
        waterBucketTransition1.setNode(waterBucket);
        waterBucketTransition1.setDuration(Duration.seconds(3));
        waterBucketTransition1.setByX(-waterBucket.getTranslateX());
        waterBucketTransition1.setByY(-waterBucket.getTranslateY());

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
        waterBucketTransition4.setByX(waterBucket.getTranslateX());
        waterBucketTransition4.setByY(waterBucket.getTranslateY());

        return new SequentialTransition(
                waterBucketTransition1,
                waterBucketTransition2,
                translate1,
                waterBucketTransition3,
                waterBucketTransition4
        );
    }
}
