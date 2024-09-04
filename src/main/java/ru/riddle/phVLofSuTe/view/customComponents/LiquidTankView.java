package ru.riddle.phVLofSuTe.view.customComponents;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import ru.riddle.phVLofSuTe.model.data.json.liquid.Liquid;
import ru.riddle.phVLofSuTe.viewModel.customComponents.LiquidTankViewModel;
import ru.riddle.phVLofSuTe.view.customComponents.properties.LiquidTypeable;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public abstract class LiquidTankView<T extends LiquidTankViewModel> extends Group implements FxmlView<LiquidTankViewModel>, LiquidTypeable, Initializable {

    private static final Logger logger = LoggerFactory.getLogger(LiquidTankView.class);

    private final ObjectProperty<Liquid> liquidType = new SimpleObjectProperty<>();

    @InjectViewModel
    private T viewModel;

    private List<Fillable> fillableParts;

    {
        fillableParts = new ArrayList<>();
    }

    @Override
    public Liquid getLiquidType() {
        return liquidTypeProperty().get();
    }

    @Override
    public void setLiquidType(Liquid liquidType) {
        liquidTypeProperty().set(liquidType);
    }

    @Override
    public ObjectProperty<Liquid> liquidTypeProperty() {
        return liquidType;
    }

    protected final void setFillableParts(Fillable... fillableParts){
        this.fillableParts = Arrays.asList(fillableParts);
        refillParts();
    }

    private void refillParts(){
        fillableParts.forEach(part -> part.fill(this.liquidTypeProperty().get().color()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        liquidTypeProperty().bind(viewModel.liquidTypeProperty());
        liquidTypeProperty().addListener(event -> refillParts());
    }
}