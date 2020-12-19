package pl.put.poznan.JSONtools.logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JSONMinifier.java
 * Class implementing Decorator Design Pattern.
 * Decorator minifying JSON String
 *
 */
public class JSONMinifier implements JSONDecorator{

    /**
     * Method for processing JSON String
     *
     * @param JSONFile JSON String
     * @return minified version of original JSON String
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
        return jsonNode.toString();
    }
}
