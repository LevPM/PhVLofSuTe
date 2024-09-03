package ru.riddle.phVLofSuTe.model.data.json.liquid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class LiquidManager {

    private static final Logger logger = LoggerFactory.getLogger(LiquidManager.class);

    private static List<Liquid> liquidList;

    public static Liquid getLiquid(String id) {
        logger.debug("Getting liquid with id: {}", id);
        for(Liquid liquid: liquidList){
            if(liquid.id().equals(id)) return liquid;
        }
        logger.warn("There is no liquid with specified id: {}", id);
        throw new IllegalArgumentException("There is no liquid with id:");
    }
}
