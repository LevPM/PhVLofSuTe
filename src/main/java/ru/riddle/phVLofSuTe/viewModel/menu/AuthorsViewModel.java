package ru.riddle.phVLofSuTe.viewModel.menu;

import de.saxsys.mvvmfx.ViewModel;
import javafx.event.ActionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.riddle.phVLofSuTe.model.ViewManager;
import ru.riddle.phVLofSuTe.model.ViewName;

public class AuthorsViewModel implements ViewModel {

    private static final Logger logger = LoggerFactory.getLogger(AuthorsViewModel.class);

    public void backToMenuScreen(ActionEvent event){
        logger.debug("backing to MenuScreen");
        ViewManager.changeScreen(event, ViewName.MENU);
    }

}