package ru.riddle.phVLofSuTe.viewModel.theory.examples;

import de.saxsys.mvvmfx.Initialize;
import de.saxsys.mvvmfx.InjectScope;
import javafx.scene.image.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.riddle.phVLofSuTe.model.Example;
import ru.riddle.phVLofSuTe.view.theory.examples.ExamplesPage;
import ru.riddle.phVLofSuTe.viewModel.theory.SimpleTheoryPaginationViewModel;
import ru.riddle.phVLofSuTe.viewModel.theory.SelectedDataScope;

import java.util.Objects;

public class ExamplesPaginationViewModel extends SimpleTheoryPaginationViewModel<Example> {

    private static final Logger logger = LoggerFactory.getLogger(ExamplesPaginationViewModel.class);

    @InjectScope
    SelectedDataScope<Example> selectedExample;

    @Initialize
    protected void initialize(){
        super.initialize();
        imageProperty().set(new Image(Objects.requireNonNull(getClass().getResource(String.format("/ru/riddle/phVLofSuTe/images/theory/examples/Example_%d.png", selectedExample.getData().id()))).toExternalForm()));
        numberLabelProperty().set("Пример решения задач #" + selectedExample.getData().id());

        pageCountProperty().set(5);
        pageFactoryProperty().set((pageIndex) -> switch (pageIndex){
                    case 0 -> new ExamplesPage(new ExamplePageDataScope(selectedExample.getData().condition(), ExamplePageDataScope.PageType.CONDITION));
                    case 1 -> new ExamplesPage(new ExamplePageDataScope(selectedExample.getData().given(), ExamplePageDataScope.PageType.GIVEN));
                    case 2 -> new ExamplesPage(new ExamplePageDataScope(selectedExample.getData().toFind(), ExamplePageDataScope.PageType.TO_FIND));
                    case 3 -> new ExamplesPage(new ExamplePageDataScope(selectedExample.getData().decision(), ExamplePageDataScope.PageType.DECISION));
                    case 4 -> new ExamplesPage(new ExamplePageDataScope(selectedExample.getData().answer(), ExamplePageDataScope.PageType.ANSWER));
                    default -> new ExamplesPage(new ExamplePageDataScope("Null page", ExamplePageDataScope.PageType.DECISION));
                }
        );
    }
}
