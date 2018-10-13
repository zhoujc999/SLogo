package external;

public interface VariableWindow {
    /**
     * The external.VariableWindow displays all of the variables and commands defined by the user. The user can then use
     * one of these variables or commands by typing it into the external.CommandWindow.
     *
     * @author Tahj Starr
     */

    /**
     * Adds a variable name and its value to the variables window.
     */
    void saveVariable(String name, String value);

    /**
     * Loads the value of a variable already defined in the variables window.
     */
    String loadVariable(String name);

    /**
     * Sets the name displayed by external.VariableWindow based on the language to which external.GUI is set.
     */
    void setName(String name);

}
