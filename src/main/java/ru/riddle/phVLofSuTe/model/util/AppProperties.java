package ru.riddle.phVLofSuTe.model.util;

import java.io.IOException;
import java.util.Properties;

public class AppProperties {

    private static String appVersion;

    public static void init(){
        var appProperties = new Properties();
        try (var in = AppProperties.class.getResourceAsStream("/app.properties")) {
            appProperties.load(in);
        } catch (IOException e){
            e.printStackTrace();
        }

        appVersion = "v" + appProperties.getProperty("app.version", "<NO-VERSION>");
    }

    public static String getAppVersion() {
        return appVersion;
    }
}
