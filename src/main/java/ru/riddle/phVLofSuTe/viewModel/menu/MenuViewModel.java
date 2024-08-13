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
        ModelUtil.changeScreen(event, FXMLs.SETTINGS_SCREEN);
    }

    public void openAuthorsScreen(ActionEvent event){
        logger.debug("Opening authors screen");
        ViewManager.changeScreen(event, ViewName.AUTHORS);
    }

    public void openMenuTESelectionScreen(ActionEvent event){
        ModelUtil.changeScreen(event, FXMLs.MENU_TE_SELECTION);
    }

    public void closeApp(){
        ModelUtil.closeApp();
    }
}