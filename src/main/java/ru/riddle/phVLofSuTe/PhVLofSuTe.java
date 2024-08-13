package ru.riddle.phVLofSuTe;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.riddle.phVLofSuTe.model.AppProperties;
import ru.riddle.phVLofSuTe.model.FXMLs;
import ru.riddle.phVLofSuTe.model.ModelUtil;

public class PhVLofSuTe extends Application {

    private static final Logger logger = LoggerFactory.getLogger(PhVLofSuTe.class);

    static {
        System.setProperty("-Dlog4j2.contextSelector", "org.apache.logging.log4j.core.async.BasicAsyncLoggerContextSelector");
    }

    @Override
    public void start(Stage primaryStage){
        logger.info("Starting application");
        Parent root = ModelUtil.downloadRoot(FXMLs.MENU_SCREEN);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("PhVLofSuTe");
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(ModelUtil.downloadIcon("/view/images/blackboard_icon.png"));
        logger.info("Showing stage");
        primaryStage.show();
    }

    @Override
    public void init(){
        logger.info("Initializing AppProperties");
        AppProperties.init();
    }

    public static void main(String[] args) {
        logger.info("Launching application...");
        launch(args);
    }
}
