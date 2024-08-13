package ru.riddle.phVLofSuTe.model;

import de.saxsys.mvvmfx.FluentViewLoader;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.riddle.phVLofSuTe.view.menu.MenuView;

public class ViewManager {

    private static final Logger logger = LoggerFactory.getLogger(ViewManager.class);

    public static void changeScreen(ActionEvent event, ViewName view){
        logger.info("Changing screen to {}", view.name());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(downloadRoot(view));
        stage.setScene(scene);
        logger.debug("Showing stage");
        stage.show();
    }

    private static Parent downloadRoot(ViewName view){
        return FluentViewLoader.fxmlView(
                switch (view){
                    case MENU -> MenuView.class;
                    default -> {
                        logger.error("View not found! View name: {}", view.name());
                        yield null;
                    }
                })
                .load().getView();
    }
}