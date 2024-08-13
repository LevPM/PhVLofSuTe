package ru.riddle.phVLofSuTe.view.menu;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import ru.riddle.phVLofSuTe.viewModel.menu.AuthorsViewModel;

public class AuthorsView implements FxmlView<AuthorsViewModel> {

    @InjectViewModel
    private AuthorsViewModel viewModel;

    public void initialize() {

    }
}