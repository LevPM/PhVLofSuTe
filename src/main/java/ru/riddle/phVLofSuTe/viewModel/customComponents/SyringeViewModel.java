package ru.riddle.phVLofSuTe.viewModel.customComponents;

import de.saxsys.mvvmfx.ViewModel;
import javafx.beans.property.*;
import javafx.scene.paint.Color;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.riddle.phVLofSuTe.model.data.json.liquid.Liquid;

public class SyringeViewModel extends BorderedLiquidTankViewModel {

    private static final Logger logger = LoggerFactory.getLogger(SyringeViewModel.class);

    public static final int SEGMENT_HEIGHT = 50;

    private IntegerProperty countOfSegments;
    private BooleanProperty isOpen;

    private ObjectProperty<Liquid> liquidType;

    private static final int DEFAULT_COUNT_OF_SEGMENTS = 5;
    private static final boolean DEFAULT_IS_OPEN = false;

    public IntegerProperty countOfSegmentsProperty(){
        if(countOfSegments == null) countOfSegments = new SimpleIntegerProperty(DEFAULT_COUNT_OF_SEGMENTS);
        return countOfSegments;
    }

    public BooleanProperty isOpenProperty() {
        if(isOpen == null) isOpen = new SimpleBooleanProperty(DEFAULT_IS_OPEN);
        return isOpen;
    }

    public abstract static class BodyViewModel implements ViewModel{

        public static class CapViewModel implements ViewModel{

        }

        public static class SegmentViewModel implements ViewModel{
            private final IntegerProperty sequenceNumber = new SimpleIntegerProperty();

            public IntegerProperty sequenceNumberProperty() {
                return sequenceNumber;
            }
        }

        public static class TipViewModel implements ViewModel{

        }
    }

    public static class PistonBodyViewModel extends BodyViewModel{

        private ObjectProperty<Color> bodyColor;
        private BooleanProperty isOpen;

        private static final Color DEFAULT_BODY_COLOR = Color.LIGHTGRAY;

        public ObjectProperty<Color> bodyColorProperty() {
            if(bodyColor == null)bodyColor = new SimpleObjectProperty<>(DEFAULT_BODY_COLOR);
            return bodyColor;
        }

        public BooleanProperty isOpenProperty() {
            if(isOpen == null) isOpen = new SimpleBooleanProperty(false);
            return isOpen;
        }
    }

    public static class LiquidBodyViewModel extends BodyViewModel{

    }
}