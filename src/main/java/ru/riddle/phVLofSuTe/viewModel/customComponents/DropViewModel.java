package ru.riddle.phVLofSuTe.viewModel.customComponents;

import de.saxsys.mvvmfx.Initialize;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class DropViewModel extends LiquidTankViewModel implements Fillable {

    private final ObjectProperty<Color> dropTipColor = new SimpleObjectProperty<>();
    private final ObjectProperty<Color> dropCircleColor = new SimpleObjectProperty<>();

    public Transition getTransition(Duration entireDuration, Node node){
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(node);
        transition.setDuration(Duration.millis(entireDuration.toMillis()/this.getLiquidType().amountOfDrops()));
        transition.setByY(100);
        transition.setCycleCount(this.getLiquidType().amountOfDrops());
        transition.setOnFinished(event -> node.setLayoutY(node.getLayoutY() - 100));

        return transition;
    }

    @Override
    public void fill(Color color) {
        this.dropTipColor.set(color);
        this.dropCircleColor.set(color);
    }

    @Initialize
    private void initialize(){
        this.setFillableParts(this);
    }

    public ObjectProperty<Color> dropTipColorProperty() {
        return dropTipColor;
    }

    public ObjectProperty<Color> dropCircleColorProperty() {
        return dropCircleColor;
    }
}
