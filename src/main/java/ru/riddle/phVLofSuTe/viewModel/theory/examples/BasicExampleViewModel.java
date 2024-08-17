package ru.riddle.phVLofSuTe.viewModel.theory.examples;

import de.saxsys.mvvmfx.InjectScope;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Node;
import javafx.util.Callback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.ViewModel;

public class BasicExampleViewModel implements ViewModel {

    private static final Logger logger = LoggerFactory.getLogger(BasicExampleViewModel.class);

    private final IntegerProperty currentPageIndex = new SimpleIntegerProperty();

    private final IntegerProperty pageCount = new SimpleIntegerProperty();

    private final ObjectProperty<Callback<Integer, Node>> pageFactory  = new SimpleObjectProperty<>();

    @InjectScope
    SelectedExampleScope selectedExampleScope;

    public IntegerProperty currentPageIndexProperty() {
        return currentPageIndex;
    }

    public IntegerProperty pageCountProperty() {
        return pageCount;
    }

    public ObjectProperty<Callback<Integer, Node>> pageFactoryProperty() {
        return pageFactory;
    }
}