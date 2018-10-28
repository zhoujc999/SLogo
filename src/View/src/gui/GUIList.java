package gui;

public interface GUIList {

    /**
     * Adds a variable name and its value to the variables window.
     */
    void save(String name, String value) ;

    /**
     * Loads the value of a variable already defined in the variables window.
     */
    String load(String name);

}