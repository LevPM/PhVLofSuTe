package ru.riddle.phVLofSuTe.view.theory.basicTheory;

import de.saxsys.mvvmfx.utils.viewlist.CachedViewModelCellFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import ru.riddle.phVLofSuTe.viewModel.theory.basicTheory.BasicTheoryChapterCellViewModel;
import ru.riddle.phVLofSuTe.viewModel.theory.basicTheory.BasicTheoryChaptersListViewModel;

import java.net.URL;
import java.util.ResourceBundle;

public class BasicTheoryChaptersListView implements FxmlView<BasicTheoryChaptersListViewModel>, Initializable {

    private static final Logger logger = LoggerFactory.getLogger(BasicTheoryChaptersListView.class);

    @FXML
    private ListView<BasicTheoryChapterCellViewModel> chaptersList;

    @InjectViewModel
    private BasicTheoryChaptersListViewModel viewModel;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logger.debug("Initializing...");
        chaptersList.setItems(viewModel.chaptersListProperty());
        chaptersList.setCellFactory(CachedViewModelCellFactory.createForFxmlView(BasicTheoryChapterCellView.class));
    }

    public void handeBackButtonAction(ActionEvent event) {
        logger.trace("Handling back button action");
        viewModel.backToTheorySelection(event);
    }
}