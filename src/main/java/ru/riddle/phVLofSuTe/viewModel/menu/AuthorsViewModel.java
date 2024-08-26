package ru.riddle.phVLofSuTe.viewModel.menu;

import de.saxsys.mvvmfx.ViewModel;
import javafx.event.ActionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.riddle.phVLofSuTe.model.view.ViewManager;
import ru.riddle.phVLofSuTe.model.view.ViewName;

public class AuthorsViewModel implements ViewModel {

    private static final Logger logger = LoggerFactory.getLogger(AuthorsViewModel.class);

    public void backToMenuScreen(ActionEvent event){
        logger.debug("Backing to MenuScreen");
        ViewManager.changeScreen(event, ViewName.MENU);
    }

}