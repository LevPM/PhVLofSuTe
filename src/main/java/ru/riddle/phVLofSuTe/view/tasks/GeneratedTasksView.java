package ru.riddle.phVLofSuTe.view.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import ru.riddle.phVLofSuTe.viewModel.tasks.GeneratedTasksViewModel;

public class GeneratedTasksView implements FxmlView<GeneratedTasksViewModel> {

    private static final Logger logger = LoggerFactory.getLogger(GeneratedTasksView.class);

    @InjectViewModel
    private GeneratedTasksViewModel viewModel;


}