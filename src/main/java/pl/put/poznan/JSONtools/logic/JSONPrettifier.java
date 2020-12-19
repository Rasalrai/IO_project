package pl.put.poznan.JSONtools.logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JSONPrettifier.java
 * Class implementing Decorator Design Pattern.
 * Decorator prettifying JSON String
 *
 */
public class JSONPrettifier implements JSONDecorator{

    /**
     * Method for processing JSON String
     *
     * @param JSONFile JSON String
     * @return pretty version of original JSON String with white spaces
     */
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
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return JSONFile;
        }
    }
}
