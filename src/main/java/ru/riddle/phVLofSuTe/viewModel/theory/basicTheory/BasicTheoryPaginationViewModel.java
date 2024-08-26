package ru.riddle.phVLofSuTe.viewModel.theory.basicTheory;

import de.saxsys.mvvmfx.Initialize;
import de.saxsys.mvvmfx.InjectScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.riddle.phVLofSuTe.model.data.ImageDataManager;
import ru.riddle.phVLofSuTe.model.data.json.TheoryChapter;
import ru.riddle.phVLofSuTe.view.theory.SimpleTheoryPage;
import ru.riddle.phVLofSuTe.viewModel.theory.SelectedDataScope;
import ru.riddle.phVLofSuTe.viewModel.theory.SimpleTheoryPageDataScope;
import ru.riddle.phVLofSuTe.viewModel.theory.SimpleTheoryPaginationViewModel;

public class BasicTheoryPaginationViewModel extends SimpleTheoryPaginationViewModel<TheoryChapter>{

    private static final Logger logger = LoggerFactory.getLogger(BasicTheoryPaginationViewModel.class);

    @InjectScope
    SelectedDataScope<TheoryChapter> selectedTheoryChapter;

    @Initialize
    protected void initialize(){
        super.initialize();
        titleLabelProperty().set(selectedTheoryChapter.getData().title());
        pageCountProperty().set(selectedTheoryChapter.getData().pages().size());
        pageFactoryProperty().set((pageIndex) -> {
            imageProperty().set(ImageDataManager.downloadImage(String.format("theory/basicTheory/theoryChapter_%d/theoryPage_%d.png", selectedTheoryChapter.getData().id(), pageIndex + 1)));
            return new SimpleTheoryPage(new SimpleTheoryPageDataScope(selectedTheoryChapter.getData().pages().get(pageIndex).text(), SimpleTheoryPageDataScope.ExamplePageType.BASIC_TITLE, selectedTheoryChapter.getData().pages().get(pageIndex).title()));
        });
    }
}