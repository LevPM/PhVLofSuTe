package ru.riddle.phVLofSuTe.model.data.json.liquid;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import javafx.scene.paint.Color;

import java.io.IOException;

public class LiquidDeserializer extends JsonDeserializer<Liquid> {
    @Override
    public Liquid deserialize(JsonParser p, DeserializationContext context) throws IOException {
        JsonNode node = p.getCodec().readTree(p);
        String id = node.get("id").asText();
        String liquidName = node.get("name").asText();
        String hexColorCode;
        double alpha = 1.0;
        if(node.get("color").isArray()){
            hexColorCode = node.get("color").get("hexCode").asText();
            alpha = node.get("color").get("alpha").doubleValue();
        } else {
            hexColorCode = node.get("color").asText();
        }
        int amountOfDrops = node.get("amountOfDrops").intValue();
        return new Liquid(id, liquidName, Color.web(hexColorCode, alpha), amountOfDrops);
    }
}
