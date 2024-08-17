package ru.riddle.phVLofSuTe.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ExamplesManager {

    private static final Logger logger = LoggerFactory.getLogger(ExamplesManager.class);

    private static final String PATH_TO_EXAMPLES = "/ru/riddle/phVLofSuTe/view/theory/examples/data/example_";

    public static Example getExampleById(int id){
        logger.info("Downloading example data with id: {}", id);
        try {
            return new ObjectMapper().readValue(ExamplesManager.class.getResource(PATH_TO_EXAMPLES + id + ".json"), Example.class);
        } catch (IOException e) {
            logger.error("Error during downloading example! Message: {}", e.getMessage());
        }
        return null;
    }
}
