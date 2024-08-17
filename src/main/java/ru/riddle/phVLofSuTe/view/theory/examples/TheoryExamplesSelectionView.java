package ru.riddle.phVLofSuTe.view.theory.examples;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import ru.riddle.phVLofSuTe.viewModel.theory.examples.TheoryExamplesSelectionViewModel;

public class TheoryExamplesSelectionView implements FxmlView<TheoryExamplesSelectionViewModel> {

    private static final Logger logger = LoggerFactory.getLogger(TheoryExamplesSelectionView.class);

    @InjectViewModel
    private TheoryExamplesSelectionViewModel viewModel;


    public void handleExampleButtonAction(ActionEvent event) {
        logger.trace("Handling ExampleButtonAction");

        String exampleId = ((Node) (event.getSource())).getId();
        int id = Integer.parseInt(String.valueOf(exampleId.charAt(exampleId.length() - 1)));

        viewModel.openExample(event, id);
    }

    public void handleLeaveButtonAction(ActionEvent event) {
        logger.trace("Handling LeaveButtonAction");
        viewModel.backToTheorySelection(event);
    }
}