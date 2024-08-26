package ru.riddle.phVLofSuTe.model;

import javafx.application.Platform;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppUtil {

    private static final Logger logger = LoggerFactory.getLogger(AppUtil.class);

    public static void closeApp(){
        logger.info("Closing app...");
        Platform.exit();
        System.exit(0);
    }
}
