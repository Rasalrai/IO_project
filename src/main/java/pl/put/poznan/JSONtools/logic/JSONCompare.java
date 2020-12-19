package pl.put.poznan.JSONtools.logic;


import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * JSONCompare.java
 * Class implementing comparison between two JSON Strings
 *
 */

public class JSONCompare {
    public String JSONFileLeft;
    public String JSONFileRight;

    /**
     * JSONCompare constructor
     * @param JSONFileLeft first JSON String
     * @param JSONFileRight second JSON String
     */
    public JSONCompare(String JSONFileLeft, String JSONFileRight){
        this.JSONFileLeft = JSONFileLeft;
        this.JSONFileRight = JSONFileRight;
    }

    /**
     * Method that unify JSON Strings and compares them
     *
     * @return diff of JSON Strings as String
     */
    public String compare() {
        JSONDecorator jsonPrettifier = new JSONPrettifier();

        Gson g = new Gson();
        Type mapType = new TypeToken<Map<String, Object>>() {}.getType();
        Map<String, Object> leftMap = g.fromJson(jsonPrettifier.decorate(this.JSONFileLeft), mapType);
        Map<String, Object> rightMap = g.fromJson(jsonPrettifier.decorate(this.JSONFileRight), mapType);
        return Maps.difference(leftMap, rightMap).toString();
    }
}
