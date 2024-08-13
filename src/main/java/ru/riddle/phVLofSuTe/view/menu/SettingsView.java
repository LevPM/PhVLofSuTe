package ru.riddle.phVLofSuTe.view.menu;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.event.ActionEvent;
import ru.riddle.phVLofSuTe.viewModel.menu.SettingsViewModel;

public class SettingsView implements FxmlView<SettingsViewModel> {

    @InjectViewModel
    private SettingsViewModel viewModel;


    public void handleBackButtonAction(ActionEvent event) {
        viewModel.backToMenuScreen(event);
    }
}