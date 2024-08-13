package ru.riddle.phVLofSuTe.view.menu;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.event.ActionEvent;
import ru.riddle.phVLofSuTe.viewModel.menu.AuthorsViewModel;

public class AuthorsView implements FxmlView<AuthorsViewModel> {

    @InjectViewModel
    private AuthorsViewModel viewModel;

    public void handleBackButtonAction(ActionEvent event) {
        viewModel.backToMenuScreen(event);
    }
}