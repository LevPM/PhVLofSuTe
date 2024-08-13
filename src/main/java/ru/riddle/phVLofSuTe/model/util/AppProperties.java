package ru.riddle.phVLofSuTe.model.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

public class AppProperties {

    private static String appVersion;
    private static final Logger logger = LoggerFactory.getLogger(AppProperties.class);

    public static void init(){
        var appProperties = new Properties();
        try (var in = AppProperties.class.getResourceAsStream("/app.properties")) {
            logger.debug("Downloading app.properties");
            appProperties.load(in);
        } catch (IOException e){
            logger.error("Exception during downloading app.properties! Message: {}", e.getMessage());
        }

        appVersion = "v" + appProperties.getProperty("app.version", "<NO-VERSION>");
        logger.debug("Setting appVersion: {}", appVersion);
    }

    public static String getAppVersion() {
        logger.trace("Returning appVersion: {}", appVersion);
        return appVersion;
    }
}
