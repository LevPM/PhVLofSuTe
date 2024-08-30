package ru.riddle.phVLofSuTe.view;

import de.saxsys.mvvmfx.utils.viewlist.CachedViewModelCellFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import ru.riddle.phVLofSuTe.model.view.ViewManager;
import ru.riddle.phVLofSuTe.viewModel.SimpleTextPageViewModel;
import ru.riddle.phVLofSuTe.viewModel.SimpleTextCellViewModel;
import ru.riddle.phVLofSuTe.viewModel.SimpleTextPageDataScope;

import java.net.URL;
import java.util.ResourceBundle;

public class SimpleTextPage extends VBox implements FxmlView<SimpleTextPageViewModel>, Initializable {

    private static final Logger logger = LoggerFactory.getLogger(SimpleTextPage.class);

    @FXML
    private Label title;

    @FXML
    private ListView<SimpleTextCellViewModel> textList;

    @InjectViewModel
    private SimpleTextPageViewModel viewModel;

    public SimpleTextPage(SimpleTextPageDataScope scope){
        ViewManager.downloadCustomComponent(this, SimpleTextPage.class, scope);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logger.debug("Initializing...");
        title.textProperty().bind(viewModel.titleProperty());
        title.getStyleClass().add(viewModel.styleClassProperty().get());
        
        textList.setItems(viewModel.textListProperty());
        textList.setCellFactory(CachedViewModelCellFactory.createForFxmlView(SimpleTextCellView.class));
    }
}