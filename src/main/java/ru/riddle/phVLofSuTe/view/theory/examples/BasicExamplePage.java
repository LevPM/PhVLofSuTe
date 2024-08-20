package ru.riddle.phVLofSuTe.view.theory.examples;

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
import ru.riddle.phVLofSuTe.viewModel.theory.examples.BasicExamplePageViewModel;
import ru.riddle.phVLofSuTe.viewModel.theory.examples.BasicTextCellViewModel;
import ru.riddle.phVLofSuTe.viewModel.theory.examples.ExamplePageDataScope;

import java.net.URL;
import java.util.ResourceBundle;

public class BasicExamplePage extends VBox implements FxmlView<BasicExamplePageViewModel>, Initializable {

    private static final Logger logger = LoggerFactory.getLogger(BasicExamplePage.class);

    @FXML
    private Label title;

    @FXML
    private ListView<BasicTextCellViewModel> textList;

    @InjectViewModel
    private BasicExamplePageViewModel viewModel;

    public BasicExamplePage(ExamplePageDataScope scope){
        ViewManager.downloadCustomComponent(this, BasicExamplePage.class, scope);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logger.debug("Initializing...");
        title.textProperty().bind(viewModel.titleProperty());
        title.getStyleClass().add(viewModel.styleClassProperty().get());
        
        textList.setItems(viewModel.textListProperty());
        textList.setCellFactory(CachedViewModelCellFactory.createForFxmlView(BasicTextCellView.class));
    }
}