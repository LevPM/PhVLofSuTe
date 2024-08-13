package ru.riddle.phVLofSuTe.model.util;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Objects;

public class ModelUtil {

    private static final Logger logger = LoggerFactory.getLogger(ModelUtil.class);

    public static void changeScreen(ActionEvent event, FXMLs fxml){
        logger.info("Starting changing screen to {}", fxml.name());
        logger.debug("Getting stage...");
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        double height = stage.getHeight();
        double width = stage.getWidth();
        boolean isFullScreen = stage.isFullScreen();
        Scene scene = new Scene(downloadRoot(fxml));
        stage.setScene(scene);
        stage.setHeight(height);
        stage.setWidth(width);
        stage.setFullScreen(isFullScreen);
        logger.info("Showing stage");
        stage.show();
    }

    public static Parent downloadRoot(FXMLs fxml){
        logger.info("Starting downloading root: {}", fxml.name());
        Parent root = null;

        try {
            logger.debug("Downloading root...");
            root = FXMLLoader.load(Objects.requireNonNull(ModelUtil.class.getResource(fxml.getPath())));
        } catch (IOException e) {
            logger.error("Exception during root downloading! Message: {}", e.getMessage());
        }

        if(fxml.getId() != null && root != null){
            logger.debug("Setting root id: {}", fxml.getId());
            root.setId(fxml.getId());
        }

        logger.info("Root downloading finished!");
        return root;
    }

    public static void downloadCustomComponentFXML(FXMLs fxml, Node controller){
        logger.debug("Starting downloading custom component. fxml: {}, controller: {}", fxml.name(), controller);

        logger.debug("Creating FXMLLoader...");
        FXMLLoader loader = new FXMLLoader(ModelUtil.class.getResource(fxml.getPath()));
        logger.trace("Setting root");
        loader.setRoot(controller);
        logger.trace("Setting controller");
        loader.setController(controller);

        try{
            logger.info("Downloading component custom component: {}", fxml.name());
            loader.load();
        } catch(IOException e){
            logger.error("Exception during custom component downloading! Message: {}", e.getMessage());
        }
        logger.debug("Custom component downloading finished!");
    }

    public static Image downloadIcon(String path){
        logger.debug("Creating icon with path: {}", path);
        return new Image(Objects.requireNonNull(ModelUtil.class.getResource(path)).toExternalForm());
    }
}