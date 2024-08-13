package ru.riddle.phVLofSuTe.view.menu;

import javafx.event.ActionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import ru.riddle.phVLofSuTe.viewModel.menu.MenuTEViewModel;

public class MenuTEView implements FxmlView<MenuTEViewModel> {

    private static final Logger logger = LoggerFactory.getLogger(MenuTEView.class);

    @InjectViewModel
    private MenuTEViewModel viewModel;


    public void handleBackButtonAction(ActionEvent event) {
        logger.debug("Handling back button action");
        viewModel.backToMenuScreen(event);
    }

    public void handleTheoryButtonAction(ActionEvent event) {
        logger.debug("Handling theory button action");
        viewModel.openTheory(event);
    }

    public void handleExperimentsButtonAction(ActionEvent event) {
        logger.debug("Handling experiments button action");
        viewModel.openExperiments(event);
    }
}