package ru.riddle.phVLofSuTe.view.menu;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.event.ActionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.riddle.phVLofSuTe.viewModel.menu.SettingsViewModel;

public class SettingsView implements FxmlView<SettingsViewModel> {

    private static final Logger logger = LoggerFactory.getLogger(SettingsView.class);

    @InjectViewModel
    private SettingsViewModel viewModel;


    public void handleBackButtonAction(ActionEvent event) {
        logger.trace("Handling BackButtonAction");
        viewModel.backToMenuScreen(event);
    }
}