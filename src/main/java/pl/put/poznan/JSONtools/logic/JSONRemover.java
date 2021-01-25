package pl.put.poznan.JSONtools.logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.Collection;

/**
 * JSONRemover.java
 * Class implementing Decorator Design Pattern.
 * Decorator removing fields from JSON String
 *
 */
public class JSONRemover implements JSONDecorator{

    private Collection<String> fieldNames;
    /**
     * Method for setting field names
     *
     * @param fieldNames Field Names String Collection
     */
    public void setfieldNames(Collection<String> fieldNames) {
        this.fieldNames = fieldNames;
    }
    /**
     * Method for processing JSON String
     *
     * @param JSONFile JSON String
     * @return original JSON String with given fields retained
     */
    @Override
    public String decorate(String JSONFile){
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode objectNode = null;
        try {
            objectNode = objectMapper.readValue(JSONFile, ObjectNode.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return JSONFile;
        }
        try {
            objectNode.remove(fieldNames);
        } catch (Exception e){
            e.printStackTrace();
            return JSONFile;
        }
        return objectNode.toString();
    }
}
