package pl.put.poznan.transformer.logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONMinifier implements JSONDecorator{

    @Override
    public String decorate(String JSONFile) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readValue(JSONFile, JsonNode.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return JSONFile;
        }
        return jsonNode.toString();
    }
}
