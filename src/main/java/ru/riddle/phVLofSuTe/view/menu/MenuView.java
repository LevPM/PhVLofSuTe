package ru.riddle.phVLofSuTe.view.menu;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.riddle.phVLofSuTe.viewModel.menu.MenuViewModel;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuView implements FxmlView<MenuViewModel>, Initializable {

    private static final Logger logger = LoggerFactory.getLogger(MenuView.class);

    @FXML
    private Label versionLabel;

    @InjectViewModel
    private MenuViewModel viewModel;

    public void handleSettingButtonAction(ActionEvent event){
        logger.trace("Handling SettingsButtonAction");
        viewModel.openSettingsScreen(event);
    }

    public void handleAuthorsButtonAction(ActionEvent event){
        logger.trace("Handling AuthorsButtonAction");
        viewModel.openAuthorsScreen(event);
    }

    public void handleStartButtonAction(ActionEvent event) {
        logger.trace("Handling StartButtonAction");
        viewModel.openMenuTESelectionScreen(event);
    }

    public void handleCloseButtonAction(){
        logger.trace("Handling CloseButtonAction");
        viewModel.closeApp();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logger.debug("Initializing MenuView");
        versionLabel.textProperty().bind(viewModel.versionProperty());
    }
}