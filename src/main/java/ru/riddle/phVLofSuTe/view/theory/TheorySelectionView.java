package ru.riddle.phVLofSuTe.view.theory;

import javafx.event.ActionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import ru.riddle.phVLofSuTe.viewModel.theory.TheorySelectionViewModel;

public class TheorySelectionView implements FxmlView<TheorySelectionViewModel> {

    private static final Logger logger = LoggerFactory.getLogger(TheorySelectionView.class);

    @InjectViewModel
    private TheorySelectionViewModel viewModel;


    public void handleBackButtonAction(ActionEvent event) {

    }

    public void handleTheoryButtonAction(ActionEvent event) {

    }

    public void handleExamplesButtonAction(ActionEvent event) {

    }
}