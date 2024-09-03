package ru.riddle.phVLofSuTe.view.customComponents;

import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.util.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.InjectViewModel;
import ru.riddle.phVLofSuTe.model.view.ViewManager;
import ru.riddle.phVLofSuTe.viewModel.customComponents.LiquidContainerViewModel;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class LiquidContainer extends BorderedLiquidTankView<LiquidContainerViewModel> implements Initializable {

    private static final Logger logger = LoggerFactory.getLogger(LiquidContainer.class);

    @InjectViewModel
    private LiquidContainerViewModel viewModel;

    @FXML
    private Polygon liquid;

    public LiquidContainer(){
        ViewManager.downloadCustomComponent(this, LiquidContainer.class);
        this.getStyleClass().add("liquid-container");
    }

    @Override
    protected void colorShape(Shape shape, Color color) {
        if(Objects.equals(shape.getId(), liquid.getId())) return;
        super.colorShape(shape, color);
    }

    public Transition getTransition(Duration duration, boolean isHiding){
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(this);
        transition.setByX(isHiding ? this.getTranslateX() : -this.getTranslateX());
        transition.setDuration(duration);

        return transition;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        liquid.fillProperty().bind(viewModel.liquidColorProperty());
    }
}