package ru.riddle.phVLofSuTe;

import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.ViewTuple;
import fr.brouillard.oss.cssfx.CSSFX;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.riddle.phVLofSuTe.model.AppProperties;
import ru.riddle.phVLofSuTe.model.ModelUtil;
import ru.riddle.phVLofSuTe.view.menu.MenuView;
import ru.riddle.phVLofSuTe.viewModel.menu.MenuViewModel;

public class PhVLofSuTe extends Application {

    private static final Logger logger = LoggerFactory.getLogger(PhVLofSuTe.class);

    static {
        System.setProperty("-Dlog4j2.contextSelector", "org.apache.logging.log4j.core.async.BasicAsyncLoggerContextSelector");
    }

    @Override
    public void start(Stage primaryStage){
        logger.info("Starting application");

        CSSFX.start();

        logger.debug("Creating Menu ViewTuple");
        ViewTuple<MenuView, MenuViewModel> menuTuple = FluentViewLoader.fxmlView(MenuView.class).load();

        Parent root = menuTuple.getView();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("PhVLofSuTe");
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(ModelUtil.downloadIcon("/ru/riddle/phVLofSuTe/images/icons/blackboard_icon.png"));
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
