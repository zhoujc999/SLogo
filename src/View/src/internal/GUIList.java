package internal;

public interface GUIList {
    /**
     * GUIList allows for the addition of strings to a list via the save method which can then be displayed visually
     * if desired. Items added to the list can then be obtained via the load method.
     *
     * @author Tahj Starr
     */

    /**
     * Adds a variable name and its value to the variables window.
     */
    void save(String name, String value);

    /**
     * Loads the value of a variable already defined in the variables window.
     */
    void load(String name);

}