package ru.riddle.phVLofSuTe.model;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.ViewModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.riddle.phVLofSuTe.view.menu.AuthorsView;
import ru.riddle.phVLofSuTe.view.menu.MenuTEView;
import ru.riddle.phVLofSuTe.view.menu.MenuView;
import ru.riddle.phVLofSuTe.view.menu.SettingsView;
import ru.riddle.phVLofSuTe.view.theory.TheorySelectionView;
import ru.riddle.phVLofSuTe.view.theory.BasicTheoryPaginationView;
import ru.riddle.phVLofSuTe.view.theory.examples.TheoryExamplesSelectionView;

public enum ViewName {

    //Menu block
    MENU(MenuView.class),
    MENU_TE(MenuTEView.class),
    AUTHORS(AuthorsView.class),
    SETTINGS(SettingsView.class),
    //------------------------------------

    //Theory block
    THEORY_SELECTION(TheorySelectionView.class),

        //Basic theory block
        //====================================

        //Examples block
        THEORY_EXAMPLES_SELECTION(TheoryExamplesSelectionView.class),

        THEORY_BASIC_EXAMPLE(BasicTheoryPaginationView.class),
        //====================================

    //------------------------------------

    //Experiments block
    EXPERIMENTS_MENU(null),
    //------------------------------------
    ;

    private final Class<? extends FxmlView<? extends ViewModel>> value;

    private static final Logger logger = LoggerFactory.getLogger(ViewName.class);

    ViewName(Class<? extends FxmlView<? extends ViewModel>> value){
        this.value = value;
    }

    public Class<? extends FxmlView<? extends ViewModel>> getValue() {
        if(value == null) logger.error("ViewName value is null! Name: {}", this.name());
        return value;
    }
}
