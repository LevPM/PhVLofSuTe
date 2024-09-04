package ru.riddle.phVLofSuTe.view.customComponents;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.util.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.InjectViewModel;
import ru.riddle.phVLofSuTe.model.view.ViewManager;
import ru.riddle.phVLofSuTe.viewModel.customComponents.DropViewModel;

import java.net.URL;
import java.util.ResourceBundle;

public class Drop extends LiquidTankView<DropViewModel> implements Initializable, Fillable {

    private static final Logger logger = LoggerFactory.getLogger(Drop.class);

    @FXML
    private Arc dropTip;

    @FXML
    private Arc dropCircle;

    @InjectViewModel
    private DropViewModel viewModel;

    public Drop() {
        ViewManager.downloadCustomComponent(this, Drop.class);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logger.trace("Initializing...");
        dropTip.fillProperty().bind(viewModel.dropTipColorProperty());
        dropCircle.fillProperty().bind(viewModel.dropCircleColorProperty());
        this.setFillableParts(this);
    }

    @Override
    public void fill(Color color) {
        this.dropTip.setFill(color);
        this.dropCircle.setFill(color);
    }

    public Transition getTransition(Duration entireDuration){
        logger.debug("Creating transition with entire duration: {} millis", entireDuration.toMillis());
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(this);
        transition.setDuration(Duration.millis(entireDuration.toMillis()/this.getLiquidType().amountOfDrops()));
        transition.setByY(100);
        transition.setCycleCount(this.getLiquidType().amountOfDrops());
        transition.setOnFinished(event -> this.setLayoutY(this.getLayoutY() - 100));

        return transition;
    }
}