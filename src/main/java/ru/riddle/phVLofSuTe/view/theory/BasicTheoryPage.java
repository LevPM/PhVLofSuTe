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
import ru.riddle.phVLofSuTe.model.ViewManager;
import ru.riddle.phVLofSuTe.viewModel.theory.BasicTheoryPageViewModel;
import ru.riddle.phVLofSuTe.viewModel.theory.BasicTheoryTextCellViewModel;
import ru.riddle.phVLofSuTe.viewModel.theory.examples.ExamplePageDataScope;

import java.net.URL;
import java.util.ResourceBundle;

public class BasicTheoryPage extends VBox implements FxmlView<BasicTheoryPageViewModel>, Initializable {

    private static final Logger logger = LoggerFactory.getLogger(BasicTheoryPage.class);

    @FXML
    private Label title;

    @FXML
    private ListView<BasicTheoryTextCellViewModel> textList;

    @InjectViewModel
    private BasicTheoryPageViewModel viewModel;

    public BasicTheoryPage(ExamplePageDataScope scope){
        ViewManager.downloadCustomComponent(this, BasicTheoryPage.class, scope);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logger.debug("Initializing...");
        title.textProperty().bind(viewModel.titleProperty());
        title.getStyleClass().add(viewModel.styleClassProperty().get());
        
        textList.setItems(viewModel.textListProperty());
        textList.setCellFactory(CachedViewModelCellFactory.createForFxmlView(ru.riddle.phVLofSuTe.view.theory.BasicTheoryTextCellView.class));
    }
}