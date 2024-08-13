package ru.riddle.phVLofSuTe.view.menu;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import ru.riddle.phVLofSuTe.viewModel.menu.MenuViewModel;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuView implements FxmlView<MenuViewModel>, Initializable {

    @FXML
    private Label versionLabel;

    @InjectViewModel
    private MenuViewModel viewModel;

    public void handleSettingButtonAction(ActionEvent event){
        viewModel.openSettingsScreen(event);
    }

    public void handleAuthorsButtonAction(ActionEvent event){
        viewModel.openAuthorsScreen(event);
    }

    public void handleStartButtonAction(ActionEvent event) {
        viewModel.openMenuTESelectionScreen(event);
    }

    public void handleCloseButtonAction(){
        viewModel.closeApp();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        versionLabel.textProperty().bind(viewModel.versionProperty());
    }
}