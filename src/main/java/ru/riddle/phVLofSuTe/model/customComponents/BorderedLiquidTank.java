package ru.riddle.phVLofSuTe.model.customComponents;

import javafx.beans.property.ObjectProperty;
import javafx.css.CssMetaData;
import javafx.css.Styleable;
import javafx.css.StyleableObjectProperty;
import javafx.css.StyleableProperty;
import javafx.css.converter.ColorConverter;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import ru.riddle.phVLofSuTe.model.customComponents.properties.styleable.ColorableBody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class BorderedLiquidTank extends LiquidTank implements ColorableBody {

    private ObjectProperty<Color> bodyColor;

    private Group coloredGroup = this; // Used for custom recoloring of part of main group

    public BorderedLiquidTank() {
        this.getStyleClass().add("bordered-liquid-tank");
    }

    protected void setColoredGroup(Group coloredGroup){
        this.coloredGroup = coloredGroup;
    }

    @Override
    public Color getBodyColor() {
        return bodyColorProperty().get();
    }

    @Override
    public void setBodyColor(Color bodyColor) {
        this.bodyColorProperty().set(bodyColor);
    }

    @Override
    public ObjectProperty<Color> bodyColorProperty() {
        if(this.bodyColor == null){
            bodyColor = new StyleableObjectProperty<>(Color.BLACK) {
                @Override
                public Object getBean() {
                    return BorderedLiquidTank.this;
                }

                @Override
                public String getName() {
                    return "bodyColor";
                }

                @Override
                public CssMetaData<? extends Styleable, Color> getCssMetaData() {
                    return BorderedLiquidTank.StyleableProperties.BODY_COLOR;
                }
            };

            bodyColor.addListener(event ->  recolor());
        }
        return this.bodyColor;
    }

    private void colorGroup(Group group, Color color){
        group.getChildren().forEach(child ->{
            if(child instanceof Group){
                colorGroup((Group) child, color);
            }
            if(child instanceof Shape){
                colorShape((Shape) child, color);
            }
        });
    }

    protected void colorShape(Shape shape, Color color){
        shape.setStroke(color);
    }

    protected void recolor(){
        colorGroup(coloredGroup, getBodyColor());
    }

    public static List<CssMetaData<? extends Styleable, ?>> getClassCssMetaData() {
        return StyleableProperties.STYLEABLES;
    }

    @Override
    public List<CssMetaData<? extends Styleable, ?>> getCssMetaData() {
        return getClassCssMetaData();
    }

    private static class StyleableProperties{
        private static final List<CssMetaData<? extends Styleable, ?>> STYLEABLES;

        private static final CssMetaData<BorderedLiquidTank, Color> BODY_COLOR;

        static{
            BODY_COLOR = new CssMetaData<>("-rl-body-color", ColorConverter.getInstance(), Color.BLACK, true) {
                @Override
                public boolean isSettable(BorderedLiquidTank borderedLiquidTank) {
                    return !borderedLiquidTank.bodyColorProperty().isBound();
                }

                @Override
                public StyleableProperty<Color> getStyleableProperty(BorderedLiquidTank borderedLiquidTank) {
                    return (StyleableProperty<Color>) borderedLiquidTank.bodyColorProperty();
                }
            };

            {
                var styleables = new ArrayList<>(Group.getClassCssMetaData());
                Collections.addAll(styleables,
                        BODY_COLOR
                );
                STYLEABLES = Collections.unmodifiableList(styleables);
            }
        }
    }
}
