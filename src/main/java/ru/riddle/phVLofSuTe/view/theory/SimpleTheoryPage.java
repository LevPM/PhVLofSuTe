package ru.riddle.phVLofSuTe.view.theory;

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
import ru.riddle.phVLofSuTe.viewModel.theory.SimpleTheoryPageViewModel;
import ru.riddle.phVLofSuTe.viewModel.theory.SimpleTheoryTextCellViewModel;
import ru.riddle.phVLofSuTe.viewModel.theory.SimpleTheoryPageDataScope;

import java.net.URL;
import java.util.ResourceBundle;

public class SimpleTheoryPage extends VBox implements FxmlView<SimpleTheoryPageViewModel>, Initializable {

    private static final Logger logger = LoggerFactory.getLogger(SimpleTheoryPage.class);

    @FXML
    private Label title;

    @FXML
    private ListView<SimpleTheoryTextCellViewModel> textList;

    @InjectViewModel
    private SimpleTheoryPageViewModel viewModel;

    public SimpleTheoryPage(SimpleTheoryPageDataScope scope){
        ViewManager.downloadCustomComponent(this, SimpleTheoryPage.class, scope);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logger.debug("Initializing...");
        title.textProperty().bind(viewModel.titleProperty());
        title.getStyleClass().add(viewModel.styleClassProperty().get());
        
        textList.setItems(viewModel.textListProperty());
        textList.setCellFactory(CachedViewModelCellFactory.createForFxmlView(SimpleTheoryTextCellView.class));
    }
}