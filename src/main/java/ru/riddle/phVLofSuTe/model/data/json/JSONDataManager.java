package ru.riddle.phVLofSuTe.model.data.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class JSONDataManager {

    private static final Logger logger = LoggerFactory.getLogger(JSONDataManager.class);

    private static final String PATH_TO_JSON_DATA = "/ru/riddle/phVLofSuTe/json/";
    private static final String PATH_TO_CUSTOM_COMPONENTS = PATH_TO_JSON_DATA + "customComponents/";
    private static final String THEORY_BLOCK = PATH_TO_JSON_DATA + "theory/";

    private static final String PATH_TO_EXAMPLES = THEORY_BLOCK + "examples/";
    private static final String PATH_TO_BASIC_THEORY = THEORY_BLOCK + "basicTheory/";

    private static final String PATH_TO_LIQUIDS = PATH_TO_CUSTOM_COMPONENTS + "liquids/";

    public static <T extends Record> T getById(int id, Class<T> clazz){
        logger.info("Downloading json data with id: {}, class: {}", id, clazz.getSimpleName());
        try {
            return new ObjectMapper().readValue(JSONDataManager.class.getResource(
                    getPathByDataClass(clazz) +
                    decapitalize(clazz.getSimpleName())
                    + "_" + id + ".json"), clazz);
        } catch(IOException e){
            logger.error("Error during downloading json data by id! Message: {}", e.getMessage());
            return null;
        }
    }

    public static <T extends Record> List<T> getListOf(Class<T> clazz){
        logger.info("Downloading list of json data with class: {}", clazz.getSimpleName());
        try {
            return new ObjectMapper().readValue(JSONDataManager.class.getResource(
                    getPathByDataClass(clazz) +
                            decapitalize(clazz.getSimpleName()) +
                            "s.json"), new TypeReference<>(){});
        } catch (IOException e) {
            logger.error("Error during downloading list of json data! Message: {}", e.getMessage());
            return null;
        }
    }

    private static String decapitalize(String string) {
        logger.trace("Decapitalizing string: {}", string);
        char[] c = string.toCharArray();
        c[0] = Character.toLowerCase(c[0]);

        return new String(c);
    }

    private static <T extends Record> String getPathByDataClass(Class<T> clazz){
        logger.trace("Getting path by data class: {}", clazz.getSimpleName());
        return switch (clazz.getSimpleName()){
            case "Example" -> PATH_TO_EXAMPLES;
            case "TheoryChapter" -> PATH_TO_BASIC_THEORY;
            case "Liquid" -> PATH_TO_LIQUIDS;
            default -> throw new IllegalStateException("Unexpected value: " + clazz.getSimpleName());
        };
    }
}