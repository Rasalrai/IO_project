package pl.put.poznan.JSONtools.logic;

import java.util.Collection;

/**
 * JSONCleaner.java
 * Interface implementing Decorator Design Pattern
 *
 */
public interface JSONCleaner {

    /**
     * Method for processing JSON String
     *
     * @param JSONFile JSON String
     * @param fieldNames Field Names Collection
     * @return processed JSON String
     */
    public String clean(String JSONFile, Collection<String> fieldNames);
}
