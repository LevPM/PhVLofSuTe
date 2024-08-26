package ru.riddle.phVLofSuTe.viewModel.theory.examples;

import de.saxsys.mvvmfx.Initialize;
import de.saxsys.mvvmfx.InjectScope;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.riddle.phVLofSuTe.model.data.json.Example;
import ru.riddle.phVLofSuTe.model.view.ViewManager;
import ru.riddle.phVLofSuTe.model.view.ViewName;
import ru.riddle.phVLofSuTe.view.theory.SimpleTheoryPage;
import ru.riddle.phVLofSuTe.viewModel.theory.SimpleTheoryPageDataScope;
import ru.riddle.phVLofSuTe.viewModel.theory.SimpleTheoryPaginationViewModel;
import ru.riddle.phVLofSuTe.viewModel.theory.SelectedDataScope;

import java.util.Objects;

public class TheoryExamplesPaginationViewModel extends SimpleTheoryPaginationViewModel {

    private static final Logger logger = LoggerFactory.getLogger(TheoryExamplesPaginationViewModel.class);

    @InjectScope
    SelectedDataScope<Example> selectedExample;

    @Override
    public void backToMenu(ActionEvent event) {
        logger.debug("Backing to TheoryExamplesSelection");
        ViewManager.changeScreen(event, ViewName.THEORY_EXAMPLES_SELECTION);
    }

    @Initialize
    protected void initialize(){
        super.initialize();
        imageProperty().set(new Image(Objects.requireNonNull(getClass().getResource(String.format("/ru/riddle/phVLofSuTe/images/theory/examples/Example_%d.png", selectedExample.getData().id()))).toExternalForm()));
        titleLabelProperty().set("Пример решения задач #" + selectedExample.getData().id());

        pageCountProperty().set(5);
        pageFactoryProperty().set((pageIndex) -> switch (pageIndex){
                    case 0 -> new SimpleTheoryPage(new SimpleTheoryPageDataScope(selectedExample.getData().condition(), SimpleTheoryPageDataScope.ExamplePageType.CONDITION));
                    case 1 -> new SimpleTheoryPage(new SimpleTheoryPageDataScope(selectedExample.getData().given(), SimpleTheoryPageDataScope.ExamplePageType.GIVEN));
                    case 2 -> new SimpleTheoryPage(new SimpleTheoryPageDataScope(selectedExample.getData().toFind(), SimpleTheoryPageDataScope.ExamplePageType.TO_FIND));
                    case 3 -> new SimpleTheoryPage(new SimpleTheoryPageDataScope(selectedExample.getData().decision(), SimpleTheoryPageDataScope.ExamplePageType.DECISION));
                    case 4 -> new SimpleTheoryPage(new SimpleTheoryPageDataScope(selectedExample.getData().answer(), SimpleTheoryPageDataScope.ExamplePageType.ANSWER));
                    default -> new SimpleTheoryPage(new SimpleTheoryPageDataScope("Null page", SimpleTheoryPageDataScope.ExamplePageType.DECISION));
                }
        );
    }
}
