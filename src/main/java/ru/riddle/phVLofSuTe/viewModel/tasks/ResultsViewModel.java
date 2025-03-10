package ru.riddle.phVLofSuTe.viewModel.tasks;

import de.saxsys.mvvmfx.Initialize;
import de.saxsys.mvvmfx.InjectScope;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.ViewModel;
import ru.riddle.phVLofSuTe.model.view.ViewManager;
import ru.riddle.phVLofSuTe.model.view.ViewName;

public class ResultsViewModel implements ViewModel {

    private static final Logger logger = LoggerFactory.getLogger(ResultsViewModel.class);

    private final ObservableList<TaskResultCellViewModel> results = FXCollections.observableArrayList();
    private final StringProperty resultText = new SimpleStringProperty();

    @InjectScope
    ResultsScope resultsScope;

    public ObservableList<TaskResultCellViewModel> resultsProperty() {
        return results;
    }

    public StringProperty resultTextProperty() {
        return resultText;
    }

    public void backToGeneratorView(ActionEvent event){
        logger.debug("Backing to generator view");
        ViewManager.changeScreen(event, ViewName.TASKS_GENERATOR);
    }

    @Initialize
    private void initialize(){
        logger.debug("Initializing...");
        results.addAll(
                resultsScope
                        .resultsProperty()
                        .get()
                        .stream()
                        .map(
                                resultTriple ->
                                        new TaskResultCellViewModel(
                                                resultTriple.getFirst(),
                                                resultTriple.getSecond(),
                                                resultTriple.getThird()
                                        )
                        ).toList()
        );
        resultText.set(
                resultsScope
                        .resultsProperty()
                        .get()
                        .stream()
                        .filter(x -> x.getSecond().equals(x.getThird()))
                        .count()
                        +
                        "/"
                        +
                        resultsScope.resultsProperty().get().size()
        );
    }
}