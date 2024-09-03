package ru.riddle.phVLofSuTe.view.customComponents;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.shape.Arc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import ru.riddle.phVLofSuTe.model.view.ViewManager;
import ru.riddle.phVLofSuTe.viewModel.customComponents.DropViewModel;

import java.net.URL;
import java.util.ResourceBundle;

public class Drop extends Group implements FxmlView<DropViewModel>, Initializable {

    private static final Logger logger = LoggerFactory.getLogger(Drop.class);

    @FXML
    private Arc dropTip;

    @FXML
    private Arc dropCircle;

    @InjectViewModel
    private DropViewModel viewModel;

    public Drop() {
        ViewManager.downloadCustomComponent(this, Drop.class);
        this.setScaleX(0.5);
        this.setScaleY(0.5);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dropTip.fillProperty().bind(viewModel.dropTipColorProperty());
        dropCircle.fillProperty().bind(viewModel.dropCircleColorProperty());

    }
}