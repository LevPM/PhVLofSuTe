package ru.riddle.phVLofSuTe.model.customComponents.syringe.syringeBody;

import javafx.beans.property.ObjectProperty;
import javafx.css.*;
import javafx.css.converter.ColorConverter;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import ru.riddle.phVLofSuTe.model.customComponents.properties.styleable.ColorableBody;
import ru.riddle.phVLofSuTe.model.util.FXMLs;
import ru.riddle.phVLofSuTe.model.util.ModelUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SyringeBody extends Group implements ColorableBody {

    private final int countOfSegments;
    private final int segmentHeight;

    private ObjectProperty<Color> bodyColor;

    public SyringeBody(int countOfSegments, int segmentHeight){
        ModelUtil.downloadCustomComponentFXML(FXMLs.SYRINGE_BODY, this);
        this.countOfSegments = countOfSegments;
        this.segmentHeight = segmentHeight;
        buildSyringeBody();
        this.getChildren().addAll(
                new SyringeTip(),
                new SyringeBodyStub(countOfSegments * segmentHeight + 10)
        );
    }

    private void buildSyringeBody(){
        for(int i = 0; i < countOfSegments; i++){
            this.getChildren().add(new SyringeBodySegment(i, segmentHeight));
        }
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
            bodyColor = new StyleableObjectProperty<>() {
                @Override
                public Object getBean() {
                    return SyringeBody.this;
                }

                @Override
                public String getName() {
                    return "bodyColor";
                }

                @Override
                public CssMetaData<? extends Styleable, Color> getCssMetaData() {
                    return StyleableProperties.BODY_COLOR;
                }
            };
        }
        return this.bodyColor;
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

        private static final CssMetaData<SyringeBody, Color> BODY_COLOR;

        static{
            BODY_COLOR = new CssMetaData<>("-rl-body-color", ColorConverter.getInstance(), Color.BLACK, true) {
                @Override
                public boolean isSettable(SyringeBody syringeBody) {
                    return !syringeBody.bodyColorProperty().isBound();
                }

                @Override
                public StyleableProperty<Color> getStyleableProperty(SyringeBody syringeBody) {
                    return (StyleableProperty<Color>) syringeBody.bodyColorProperty();
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
