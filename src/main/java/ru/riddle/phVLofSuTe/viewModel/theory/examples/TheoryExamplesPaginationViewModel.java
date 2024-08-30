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
import ru.riddle.phVLofSuTe.view.SimpleTextPage;
import ru.riddle.phVLofSuTe.viewModel.SimpleTextPageDataScope;
import ru.riddle.phVLofSuTe.viewModel.SimpleTextPaginationViewModel;
import ru.riddle.phVLofSuTe.viewModel.SelectedDataScope;

import java.util.Objects;

public class TheoryExamplesPaginationViewModel extends SimpleTextPaginationViewModel {

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
                    case 0 -> new SimpleTextPage(new SimpleTextPageDataScope(selectedExample.getData().condition(), SimpleTextPageDataScope.ExamplePageType.CONDITION));
                    case 1 -> new SimpleTextPage(new SimpleTextPageDataScope(selectedExample.getData().given(), SimpleTextPageDataScope.ExamplePageType.GIVEN));
                    case 2 -> new SimpleTextPage(new SimpleTextPageDataScope(selectedExample.getData().toFind(), SimpleTextPageDataScope.ExamplePageType.TO_FIND));
                    case 3 -> new SimpleTextPage(new SimpleTextPageDataScope(selectedExample.getData().decision(), SimpleTextPageDataScope.ExamplePageType.DECISION));
                    case 4 -> new SimpleTextPage(new SimpleTextPageDataScope(selectedExample.getData().answer(), SimpleTextPageDataScope.ExamplePageType.ANSWER));
                    default -> new SimpleTextPage(new SimpleTextPageDataScope("Null page", SimpleTextPageDataScope.ExamplePageType.DECISION));
                }
        );
    }
}
