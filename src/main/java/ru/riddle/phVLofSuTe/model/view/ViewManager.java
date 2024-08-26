package ru.riddle.phVLofSuTe.model.view;

import de.saxsys.mvvmfx.*;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ViewManager {

    private static final Logger logger = LoggerFactory.getLogger(ViewManager.class);

    public static void changeScreen(ActionEvent event, ViewName view, Scope... scopes){
        logger.info("Changing screen to {}", view.name());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(downloadRoot(view, scopes));
        stage.setScene(scene);
        logger.debug("Showing stage");
        stage.show();
    }

    public static void changeScreen(ActionEvent event, ViewName view){
        changeScreen(event, view, new Scope[]{});
    }

    private static Parent downloadRoot(ViewName view, Scope... scopes){
        if(scopes == null || scopes.length == 0){
            logger.debug("Loading view: {}", view.name());
            return FluentViewLoader.fxmlView(view.getValue()).load().getView();
        } else {
            logger.debug("Loading view: {}. With Scopes(Count): {}", view.name(), scopes.length);
            return FluentViewLoader.fxmlView(view.getValue()).providedScopes(scopes).load().getView();
        }
    }

    public static <T extends FxmlView<? extends ViewModel>> void downloadCustomComponent(T view, Class<T> clazz, Scope... scopes){
        if(scopes == null || scopes.length == 0){
          logger.debug("Loading custom component: {}", clazz.getSimpleName());
            FluentViewLoader.fxmlView(clazz).root(view).codeBehind(view).load();
        } else {
            logger.debug("Loading custom component: {}. With Scopes(Count): {}", clazz.getSimpleName(), scopes.length);
            FluentViewLoader.fxmlView(clazz).root(view).codeBehind(view).providedScopes(scopes).load();
        }
    }

    public static <T extends FxmlView<? extends ViewModel>> void downloadCustomComponent(T view, Class<T> clazz){
        downloadCustomComponent(view, clazz, new Scope[]{});
    }
}