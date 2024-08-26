package ru.riddle.phVLofSuTe.viewModel.theory;

import de.saxsys.mvvmfx.Scope;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.riddle.phVLofSuTe.model.dataManagement.JSONDataManager;

public class SelectedDataScope<T extends Record> implements Scope {

    private static final Logger logger = LoggerFactory.getLogger(SelectedDataScope.class);

    private final ObjectProperty<T> data = new SimpleObjectProperty<>();

    private SelectedDataScope(T data) {
        this.data.set(data);
    }

    public SelectedDataScope(int id, Class<T> dataClass){
        this(JSONDataManager.getById(id, dataClass));
    }

    public T getData() {
        return data.get();
    }

    public ObjectProperty<T> dataProperty() {
        return data;
    }
}
