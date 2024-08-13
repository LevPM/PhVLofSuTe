package ru.riddle.phVLofSuTe.view.menu;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.event.ActionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.riddle.phVLofSuTe.viewModel.menu.AuthorsViewModel;

public class AuthorsView implements FxmlView<AuthorsViewModel> {

    private static final Logger logger = LoggerFactory.getLogger(AuthorsView.class);

    @InjectViewModel
    private AuthorsViewModel viewModel;

    public void handleBackButtonAction(ActionEvent event) {
        logger.trace("Handling BackButtonAction");
        viewModel.backToMenuScreen(event);
    }
}