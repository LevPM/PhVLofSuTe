package ru.riddle.phVLofSuTe.model.data.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class JSONDataManager {

    private static final Logger logger = LoggerFactory.getLogger(JSONDataManager.class);

    private static final String PATH_TO_JSON_DATA = "/ru/riddle/phVLofSuTe/json/";
    private static final String THEORY_BLOCK = PATH_TO_JSON_DATA + "theory/";

    private static final String PATH_TO_EXAMPLES = THEORY_BLOCK + "examples/";

    public static <T extends Record> T getById(int id, Class<T> clazz){
        logger.info("Downloading example json data with id: {}, class: {}", id, clazz.getSimpleName());
        try {
            return new ObjectMapper().readValue(JSONDataManager.class.getResource(
                    switch (clazz.getSimpleName()){
                        case "Example" -> PATH_TO_EXAMPLES + clazz.getSimpleName().toLowerCase();
                        default -> null;
                    }
                    + "_" + id + ".json"), clazz);
        } catch(IOException e){
            logger.error("Error during downloading example! Message: {}", e.getMessage());
            return null;
        }
    }
}
