package ru.riddle.phVLofSuTe.model;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.ViewModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.riddle.phVLofSuTe.view.menu.AuthorsView;
import ru.riddle.phVLofSuTe.view.menu.MenuView;
import ru.riddle.phVLofSuTe.view.menu.SettingsView;

public enum ViewName {

    MENU(MenuView.class),
    MENU_TE(null),
    AUTHORS(AuthorsView.class),
    SETTINGS(SettingsView.class),
    ;

    private final Class<? extends FxmlView<? extends ViewModel>> value;

    private static final Logger logger = LoggerFactory.getLogger(ViewName.class);

    ViewName(Class<? extends FxmlView<? extends ViewModel>> value){
        this.value = value;
    }

    public Class<? extends FxmlView<? extends ViewModel>> getValue() {
        logger.trace("Returning ViewName value: {}", value.getName());
        return value;
    }

}
