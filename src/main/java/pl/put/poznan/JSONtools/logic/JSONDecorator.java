package pl.put.poznan.JSONtools.logic;

/**
 * JSONDecorator.java
 * Interface implementing Decorator Design Pattern
 *
 */
public interface JSONDecorator {

    /**
     * Method for processing JSON String
     *
     * @param JSONFile JSON String
     * @return processed JSON String
     */
    public String decorate(String JSONFile);
}
