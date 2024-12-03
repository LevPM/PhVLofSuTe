package ru.riddle.phVLofSuTe.view.theory.basicTheory;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import ru.riddle.phVLofSuTe.viewModel.theory.basicTheory.BasicTheoryChapterCellViewModel;

import java.net.URL;
import java.util.ResourceBundle;

public class BasicTheoryChapterCellView implements FxmlView<BasicTheoryChapterCellViewModel>, Initializable {

    private static final Logger logger = LoggerFactory.getLogger(BasicTheoryChapterCellView.class);

    @FXML
    private Button button;

    @FXML
    private ImageView icon;

    @InjectViewModel
    private BasicTheoryChapterCellViewModel viewModel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logger.debug("Initializing...");
        button.textProperty().bind(viewModel.textProperty());
        button.setOnAction(event -> viewModel.openChapter(event));
        icon.imageProperty().bind(viewModel.imageProperty());
    }
}