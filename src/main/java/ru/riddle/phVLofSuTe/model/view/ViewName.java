package ru.riddle.phVLofSuTe.model.view;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.ViewModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.riddle.phVLofSuTe.view.tasks.GeneratedTasksPaginationView;
import ru.riddle.phVLofSuTe.view.tasks.ResultsView;
import ru.riddle.phVLofSuTe.view.tasks.TasksGeneratorView;
import ru.riddle.phVLofSuTe.view.menu.MenuView;
import ru.riddle.phVLofSuTe.view.theory.TheorySelectionView;
import ru.riddle.phVLofSuTe.view.theory.basicTheory.BasicTheoryChaptersListView;
import ru.riddle.phVLofSuTe.view.theory.basicTheory.BasicTheoryPaginationView;
import ru.riddle.phVLofSuTe.view.theory.examples.TheoryExamplesPaginationView;
import ru.riddle.phVLofSuTe.view.theory.examples.TheoryExamplesSelectionView;

public enum ViewName {

    //Menu block
    MENU(MenuView.class),
    //------------------------------------

    //Theory block
    THEORY_SELECTION(TheorySelectionView.class),

        //Basic theory block
        //====================================

        //Examples block
        THEORY_EXAMPLES_SELECTION(TheoryExamplesSelectionView.class),

        THEORY_BASIC_EXAMPLE(TheoryExamplesPaginationView.class),

        THEORY_BASIC_THEORY_CHAPTERS_LIST(BasicTheoryChaptersListView.class),

        THEORY_BASIC_THEORY_CHAPTER(BasicTheoryPaginationView.class),
        //====================================

    //------------------------------------

    //Tasks block
    TASKS_GENERATOR(TasksGeneratorView.class),
    TASKS_PAGINATION(GeneratedTasksPaginationView.class),
    TASKS_RESULTS(ResultsView.class),
    
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
