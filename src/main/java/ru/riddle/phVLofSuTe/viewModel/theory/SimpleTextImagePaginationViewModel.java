package ru.riddle.phVLofSuTe.viewModel.theory;

import javafx.beans.property.*;
import javafx.scene.image.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.riddle.phVLofSuTe.viewModel.SimpleTextPaginationViewModel;

public abstract class SimpleTextImagePaginationViewModel extends SimpleTextPaginationViewModel {

    private static final Logger logger = LoggerFactory.getLogger(SimpleTextImagePaginationViewModel.class);

    private final ObjectProperty<Image> image = new SimpleObjectProperty<>();

    public ObjectProperty<Image> imageProperty() {
        return image;
    }
}