package external;

public interface CommandWindow {
    /**
     * The external.CommandWindow is the site where the user may type in text in order to execute the desired command. It is able
     * set its text to something that the user may not have typed in. This is useful for loading commands from the
     * internal.CommandHistory.
     *
     * @author Tahj Starr
     */

    /**
     * Returns text input from user.
     */
    String getInput();

    /**
     * Sets the text input to the specified value.
     */
    void setInput(String command);

    /**
     * Sets the name displayed by external.CommandWindow based on the language to which external.GUI is set.
     */
    void setName(String name);

}