package ru.riddle.phVLofSuTe.viewModel.theory.basicTheory;

import de.saxsys.mvvmfx.Initialize;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.ViewModel;
import ru.riddle.phVLofSuTe.model.data.ImageDataManager;
import ru.riddle.phVLofSuTe.model.data.json.JSONDataManager;
import ru.riddle.phVLofSuTe.model.data.json.TheoryChapterInfo;
import ru.riddle.phVLofSuTe.model.view.ViewManager;
import ru.riddle.phVLofSuTe.model.view.ViewName;

import java.util.Objects;

public class BasicTheoryChaptersListViewModel implements ViewModel {

    private static final Logger logger = LoggerFactory.getLogger(BasicTheoryChaptersListViewModel.class);

    private final ObservableList<BasicTheoryChapterCellViewModel> chaptersList = FXCollections.observableArrayList();

    public ObservableList<BasicTheoryChapterCellViewModel> chaptersListProperty() {
        return chaptersList;
    }

    public void backToTheorySelection(ActionEvent event){
        logger.debug("Backing to theory selection screen");
        ViewManager.changeScreen(event, ViewName.THEORY_SELECTION);
    }

    @Initialize
    private void initialize(){
        logger.debug("Initializing...");
        chaptersList.addAll(Objects.requireNonNull(JSONDataManager.getListOf(TheoryChapterInfo.class))
                .stream()
                .map(info ->
                        new BasicTheoryChapterCellViewModel(info.title(),
                                ImageDataManager.downloadImageIfExist(
                                        "icons/theoryChaptersIcons/chapter_" + info.id() + "_icon.png",
                                        "icons/theoryChaptersIcons/chapter_" + 0 + "_icon.png"
                                ),
                                info.id()
                        )
                )
                .toList()
        );
    }
}