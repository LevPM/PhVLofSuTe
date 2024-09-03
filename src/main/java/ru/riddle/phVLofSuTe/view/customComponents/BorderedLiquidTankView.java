package ru.riddle.phVLofSuTe.view.customComponents;

import javafx.beans.property.ObjectProperty;
import javafx.css.CssMetaData;
import javafx.css.Styleable;
import javafx.css.StyleableObjectProperty;
import javafx.css.StyleableProperty;
import javafx.css.converter.ColorConverter;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.saxsys.mvvmfx.InjectViewModel;
import ru.riddle.phVLofSuTe.view.customComponents.properties.styleable.ColorableBody;
import ru.riddle.phVLofSuTe.viewModel.customComponents.BorderedLiquidTankViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class BorderedLiquidTankView<T extends BorderedLiquidTankViewModel> extends LiquidTankView<BorderedLiquidTankViewModel> implements ColorableBody {

    private static final Logger logger = LoggerFactory.getLogger(BorderedLiquidTankView.class);

    @InjectViewModel
    private T viewModel;

    private ObjectProperty<Color> bodyColor;
    private Group coloredGroup = this; // Used for custom recoloring of part of main group

    public BorderedLiquidTankView() {
        this.getStyleClass().add("bordered-liquid-tank");
    }

    protected void setColoredGroup(Group coloredGroup){
        this.coloredGroup = coloredGroup;
    }

    @Override
    public final Color getBodyColor() {
        return bodyColorProperty().get();
    }

    @Override
    public final void setBodyColor(Color bodyColor) {
        this.bodyColorProperty().set(bodyColor);
    }

    @Override
    public final ObjectProperty<Color> bodyColorProperty() {
        if(this.bodyColor == null){
            bodyColor = new StyleableObjectProperty<>(Color.SILVER) {
                @Override
                public Object getBean() {
                    return BorderedLiquidTankView.this;
                }
                @Override
                public String getName() {
                    return "bodyColor";
                }
                @Override
                public CssMetaData<? extends Styleable, Color> getCssMetaData() {
                    return BorderedLiquidTankView.StyleableProperties.BODY_COLOR;
                }
            };
            bodyColor.addListener(event ->  recolor());
        }
        return this.bodyColor;
    }

    private void colorGroup(Group group, Color color){
        group.getChildren().forEach(child ->{
            if(child instanceof Group group1){
                colorGroup(group1, color);
            }
            if(child instanceof Shape shape){
                colorShape(shape, color);
            }
        });
    }

    protected void colorShape(Shape shape, Color color){
        shape.setStroke(color);
    }

    protected final void recolor(){
        colorGroup(coloredGroup, getBodyColor());
    }

    public static List<CssMetaData<? extends Styleable, ?>> getClassCssMetaData() {
        return BorderedLiquidTankView.StyleableProperties.STYLEABLES;
    }

    @Override
    public List<CssMetaData<? extends Styleable, ?>> getCssMetaData() {
        return getClassCssMetaData();
    }

    private static class StyleableProperties{

        private static final List<CssMetaData<? extends Styleable, ?>> STYLEABLES;

        private static final CssMetaData<? extends BorderedLiquidTankView<? extends BorderedLiquidTankViewModel>, Color> BODY_COLOR;

        static{
            BODY_COLOR = new CssMetaData<>("-rl-body-color", ColorConverter.getInstance(), Color.SILVER, true) {
                @Override
                public boolean isSettable(BorderedLiquidTankView borderedLiquidTank) {
                    return !borderedLiquidTank.bodyColorProperty().isBound();
                }
                @Override
                public StyleableProperty<Color> getStyleableProperty(BorderedLiquidTankView<? extends BorderedLiquidTankViewModel> borderedLiquidTank) {
                    return (StyleableProperty<Color>) borderedLiquidTank.bodyColorProperty();
                }
            };
            {
                var styleables = new ArrayList<>(LiquidTankView.getClassCssMetaData());
                Collections.addAll(styleables,
                        BODY_COLOR
                );
                STYLEABLES = Collections.unmodifiableList(styleables);
            }
        }
    }
}