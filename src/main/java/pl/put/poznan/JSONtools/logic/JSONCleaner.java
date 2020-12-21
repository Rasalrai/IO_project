package pl.put.poznan.JSONtools.logic;

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
     * @return processed JSON String
     */
    public String clean(String JSONFile);
}
