package pl.put.poznan.JSONtools.logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.Collection;

/**
 * JSONChooser.java
 * Class implementing Decorator Design Pattern.
 * Decorator retaining fields from JSON String
 *
 */
public class JSONChooser implements JSONCleaner{

    /**
     * Method for processing JSON String
     *
     * @param JSONFile JSON String
     * @param fieldNames Field Names Collection
     * @return original JSON String with given fields retained
     */
    @Override
    public String clean(String JSONFile, Collection<String> fieldNames){
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode objectNode = null;
        try {
            objectNode = objectMapper.readValue(JSONFile, ObjectNode.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return JSONFile;
        }
        try {
            objectNode.retain(fieldNames);
        } catch (Exception e){
            e.printStackTrace();
            return JSONFile;
        }
        return objectNode.toString();
    }
}
