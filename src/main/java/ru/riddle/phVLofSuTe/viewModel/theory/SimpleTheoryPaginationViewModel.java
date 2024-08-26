package ru.riddle.phVLofSuTe.viewModel.theory;

import de.saxsys.mvvmfx.Initialize;
import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.util.Callback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.ViewModel;

public abstract class SimpleTheoryPaginationViewModel implements ViewModel {

    private static final Logger logger = LoggerFactory.getLogger(SimpleTheoryPaginationViewModel.class);

    private final IntegerProperty currentPageIndex = new SimpleIntegerProperty(0);
    private final IntegerProperty pageCount = new SimpleIntegerProperty(1);
    private final ObjectProperty<Callback<Integer, Node>> pageFactory  = new SimpleObjectProperty<>();

    private final BooleanProperty previousButtonDisable = new SimpleBooleanProperty(true);
    private final BooleanProperty nextButtonDisable = new SimpleBooleanProperty(false);

    private final ObjectProperty<Image> image = new SimpleObjectProperty<>();

    private final StringProperty titleLabel = new SimpleStringProperty();

    public void backToPreviousScreen(){
        logger.debug("Backing to PreviousScreen");
        if(currentPageIndex.get() > 0){
            currentPageIndex.set(currentPageIndex.get() - 1);
        }
    }

    public abstract void backToMenu(ActionEvent event);

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

    public StringProperty titleLabelProperty() {
        return titleLabel;
    }

    public BooleanProperty nextButtonDisableProperty() {
        currentPageIndex.addListener(event -> nextButtonDisable.set(currentPageIndex.get() == pageCount.get() - 1));
        return nextButtonDisable;
    }

    public BooleanProperty previousButtonDisableProperty() {
        currentPageIndex.addListener(event -> previousButtonDisable.set(currentPageIndex.get() == 0));
        return previousButtonDisable;
    }

    public ObjectProperty<Image> imageProperty() {
        return image;
    }

    @Initialize
    protected void initialize(){
        logger.debug("Initializing...");
    }
}