package ru.riddle.phVLofSuTe.model.data;

import javafx.scene.image.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class ImageDataManager {

    private static final Logger logger = LoggerFactory.getLogger(ImageDataManager.class);

    private static final String pathToImages = "/ru/riddle/phVLofSuTe/images/";

    public static Image downloadImage(String path){ /*Needs relative path to image from images folder*/
        logger.debug("Creating icon with path: {}", path);
        return new Image(Objects.requireNonNull(ImageDataManager.class.getResource(pathToImages + path)).toExternalForm());
    }

    public static Image downloadImageIfExist(String path, String alternativePath){
        logger.debug("Trying to create icon with path: {}, alternative path: {}", path, alternativePath);
        return
                new Image(
                        ImageDataManager.class.getResource(pathToImages + path) == null ?
                                Objects.requireNonNull(ImageDataManager.class.getResource(pathToImages + alternativePath)).toExternalForm() :
                                Objects.requireNonNull(ImageDataManager.class.getResource(pathToImages + path)).toExternalForm()
                        );
    }
}
