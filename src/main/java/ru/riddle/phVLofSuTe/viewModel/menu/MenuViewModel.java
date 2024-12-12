package ru.riddle.phVLofSuTe.viewModel.menu;

import de.saxsys.mvvmfx.ViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.riddle.phVLofSuTe.model.*;
import ru.riddle.phVLofSuTe.model.view.ViewManager;
import ru.riddle.phVLofSuTe.model.view.ViewName;

public class MenuViewModel implements ViewModel {

    private static final Logger logger = LoggerFactory.getLogger(MenuViewModel.class);

    private StringProperty version;

    public StringProperty versionProperty(){
        if(version == null){
            logger.trace("Cresting version variable");
            version = new SimpleStringProperty(AppProperties.getAppVersion());
        }
        logger.debug("Returning versionProperty, value: {}", version.get());
        return version;
    }

    public void openTheory(ActionEvent event){
        logger.debug("Opening theory");
        ViewManager.changeScreen(event, ViewName.THEORY_SELECTION);
    }

    public void openTasks(ActionEvent event){
        logger.debug("Opening tasks");
        ViewManager.changeScreen(event, ViewName.TASKS_GENERATOR);
    }

    public void closeApp(){
        AppUtil.closeApp();
    }
}