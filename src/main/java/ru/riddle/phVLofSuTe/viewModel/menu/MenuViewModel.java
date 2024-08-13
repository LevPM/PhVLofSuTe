package ru.riddle.phVLofSuTe.viewModel.menu;

import de.saxsys.mvvmfx.ViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.riddle.phVLofSuTe.model.*;

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

    public void openSettingsScreen(ActionEvent event){
        logger.debug("Opening settings screen");
        ViewManager.changeScreen(event, ViewName.SETTINGS);
    }

    public void openAuthorsScreen(ActionEvent event){
        logger.debug("Opening authors screen");
        ViewManager.changeScreen(event, ViewName.AUTHORS);
    }

    public void openMenuTESelectionScreen(ActionEvent event){
        logger.debug("Opening TE selection screen");
        ViewManager.changeScreen(event, ViewName.MENU_TE);
    }

    public void closeApp(){
        ModelUtil.closeApp();
    }
}