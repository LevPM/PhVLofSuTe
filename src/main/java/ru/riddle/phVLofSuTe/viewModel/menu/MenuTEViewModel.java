package ru.riddle.phVLofSuTe.viewModel.menu;

import javafx.event.ActionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.ViewModel;
import ru.riddle.phVLofSuTe.model.view.ViewManager;
import ru.riddle.phVLofSuTe.model.view.ViewName;

public class MenuTEViewModel implements ViewModel {

    private static final Logger logger = LoggerFactory.getLogger(MenuTEViewModel.class);

    public void backToMenuScreen(ActionEvent event){
        logger.debug("Backing to menu");
        ViewManager.changeScreen(event, ViewName.MENU);
    }

    public void openTheory(ActionEvent event){
        logger.debug("Opening theory");
        ViewManager.changeScreen(event, ViewName.THEORY_SELECTION);
    }

    public void openExperiments(ActionEvent event){
        logger.debug("Opening experiments");
        ViewManager.changeScreen(event, ViewName.EXPERIMENTS_SELECTION);
    }
}