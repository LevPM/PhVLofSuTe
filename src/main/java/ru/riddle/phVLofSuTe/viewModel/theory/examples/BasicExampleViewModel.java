package ru.riddle.phVLofSuTe.viewModel.theory.examples;

import de.saxsys.mvvmfx.Initialize;
import de.saxsys.mvvmfx.InjectScope;
import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.util.Callback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.ViewModel;
import ru.riddle.phVLofSuTe.model.ViewManager;
import ru.riddle.phVLofSuTe.model.ViewName;
import ru.riddle.phVLofSuTe.view.theory.examples.BasicExamplePage;

import java.util.Objects;

public class BasicExampleViewModel implements ViewModel {

    private static final Logger logger = LoggerFactory.getLogger(BasicExampleViewModel.class);

    private final IntegerProperty currentPageIndex = new SimpleIntegerProperty(0);
    private final IntegerProperty pageCount = new SimpleIntegerProperty(1);
    private final ObjectProperty<Callback<Integer, Node>> pageFactory  = new SimpleObjectProperty<>();

    private final BooleanProperty previousButtonDisable = new SimpleBooleanProperty(true);
    private final BooleanProperty nextButtonDisable = new SimpleBooleanProperty(false);

    private final ObjectProperty<Image> exampleImage = new SimpleObjectProperty<>();

    private final StringProperty exampleNumberLabel = new SimpleStringProperty();

    @InjectScope
    SelectedExampleScope selectedExampleScope;

    public void backToPreviousScreen(){
        logger.debug("Backing to PreviousScreen");
        if(currentPageIndex.get() > 0){
            currentPageIndex.set(currentPageIndex.get() - 1);
        }
    }

    public void backToTheoryExamplesSelection(ActionEvent event){
        logger.debug("Backing to TheoryExamplesSelection");
        ViewManager.changeScreen(event, ViewName.THEORY_EXAMPLES_SELECTION);
    }

    public void goToNextScreen(){
        logger.debug("Going to NextScreen");
        if(currentPageIndex.get() < pageCount.get() - 1){
            currentPageIndex.set(currentPageIndex.get() + 1);
        }
    }

    public IntegerProperty currentPageIndexProperty() {
        return currentPageIndex;
    }

    public IntegerProperty pageCountProperty() {
        return pageCount;
    }

    public ObjectProperty<Callback<Integer, Node>> pageFactoryProperty() {
        return pageFactory;
    }

    public StringProperty exampleNumberLabelProperty() {
        return exampleNumberLabel;
    }

    public BooleanProperty nextButtonDisableProperty() {
        currentPageIndex.addListener(event -> nextButtonDisable.set(currentPageIndex.get() == pageCount.get() - 1));
        return nextButtonDisable;
    }

    public BooleanProperty previousButtonDisableProperty() {
        currentPageIndex.addListener(event -> previousButtonDisable.set(currentPageIndex.get() == 0));
        return previousButtonDisable;
    }

    public ObjectProperty<Image> exampleImageProperty() {
        return exampleImage;
    }

    @Initialize
    private void initialize(){
        logger.debug("Initializing...");
        exampleImage.set(new Image(Objects.requireNonNull(getClass().getResource(String.format("/ru/riddle/phVLofSuTe/images/theory/examples/Example_%d.png", selectedExampleScope.getExample().id()))).toExternalForm()));
        exampleNumberLabel.set("Пример решения задач #" + selectedExampleScope.getExample().id());

        pageCount.set(5);
        pageFactory.set((pageIndex) -> switch (pageIndex){
                case 0 -> new BasicExamplePage(new ExamplePageDataScope(selectedExampleScope.getExample().condition(), ExamplePageDataScope.PageType.CONDITION));
                case 1 -> new BasicExamplePage(new ExamplePageDataScope(selectedExampleScope.getExample().given(), ExamplePageDataScope.PageType.GIVEN));
                case 2 -> new BasicExamplePage(new ExamplePageDataScope(selectedExampleScope.getExample().toFind(), ExamplePageDataScope.PageType.TO_FIND));
                case 3 -> new BasicExamplePage(new ExamplePageDataScope(selectedExampleScope.getExample().decision(), ExamplePageDataScope.PageType.DECISION));
                case 4 -> new BasicExamplePage(new ExamplePageDataScope(selectedExampleScope.getExample().answer(), ExamplePageDataScope.PageType.ANSWER));
                default -> new BasicExamplePage(new ExamplePageDataScope("Null page", ExamplePageDataScope.PageType.DECISION));
            }
        );
    }
}