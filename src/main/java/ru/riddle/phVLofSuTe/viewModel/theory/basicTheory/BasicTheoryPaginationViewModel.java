package ru.riddle.phVLofSuTe.viewModel.theory.basicTheory;

import de.saxsys.mvvmfx.Initialize;
import de.saxsys.mvvmfx.InjectScope;
import javafx.event.ActionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.riddle.phVLofSuTe.model.data.ImageDataManager;
import ru.riddle.phVLofSuTe.model.data.json.TheoryChapter;
import ru.riddle.phVLofSuTe.model.view.ViewManager;
import ru.riddle.phVLofSuTe.model.view.ViewName;
import ru.riddle.phVLofSuTe.view.SimpleTextPage;
import ru.riddle.phVLofSuTe.viewModel.SelectedDataScope;
import ru.riddle.phVLofSuTe.viewModel.SimpleTextPageDataScope;
import ru.riddle.phVLofSuTe.viewModel.SimpleTextPaginationViewModel;

public class BasicTheoryPaginationViewModel extends SimpleTextPaginationViewModel {

    private static final Logger logger = LoggerFactory.getLogger(BasicTheoryPaginationViewModel.class);

    @InjectScope
    SelectedDataScope<TheoryChapter> selectedTheoryChapter;

    @Override
    public void backToMenu(ActionEvent event) {
        logger.debug("Backing to TheoryExamplesSelection");
        ViewManager.changeScreen(event, ViewName.THEORY_SELECTION);
    }
    @Initialize
    protected void initialize(){
        super.initialize();
        titleLabelProperty().set(selectedTheoryChapter.getData().title());
        pageCountProperty().set(selectedTheoryChapter.getData().pages().size());
        pageFactoryProperty().set((pageIndex) -> {
            imageProperty().set(ImageDataManager.downloadImage(String.format("theory/basicTheory/theoryChapter_%d/theoryPage_%d.png", selectedTheoryChapter.getData().id(), pageIndex + 1)));
            return new SimpleTextPage(
                    new SimpleTextPageDataScope(
                            selectedTheoryChapter.getData().pages().get(pageIndex).text(),
                            "theory-basic-theory-label",
                            selectedTheoryChapter.getData().pages().get(pageIndex).title()));
        });
    }
}