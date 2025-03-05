package ru.riddle.phVLofSuTe.viewModel.theory.basicTheory;

import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.ViewModel;
import ru.riddle.phVLofSuTe.model.data.json.TheoryChapter;
import ru.riddle.phVLofSuTe.model.view.ViewManager;
import ru.riddle.phVLofSuTe.model.view.ViewName;
import ru.riddle.phVLofSuTe.viewModel.SelectedDataScope;

public class BasicTheoryChapterCellViewModel implements ViewModel {

    private static final Logger logger = LoggerFactory.getLogger(BasicTheoryChapterCellViewModel.class);

    private final StringProperty text = new SimpleStringProperty();
    private final ObjectProperty<Image> image = new SimpleObjectProperty<>();
    private final IntegerProperty id = new SimpleIntegerProperty();


    public BasicTheoryChapterCellViewModel(String text, Image image, int id) {
        this.text.set(text);
        this.image.set(image);
        this.id.set(id);
    }

    public ObjectProperty<Image> imageProperty() {
        return image;
    }

    public StringProperty textProperty() {
        return text;
    }

    public void openChapter(ActionEvent event){
        logger.debug("Opening chapter with title: {}", text.get());
        ViewManager.changeScreen(event, ViewName.THEORY_BASIC_THEORY_CHAPTER, new SelectedDataScope<>(id.get(), TheoryChapter.class));
    }
}