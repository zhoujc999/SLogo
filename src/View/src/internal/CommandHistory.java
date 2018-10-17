package internal;

public interface CommandHistory {
    /**
     * CommandHistory keeps track of anything that the user runs or tries to run from the CommandWindow and displays it
     * to the user. Users can load a command by clicking on it. The GUI handles saving commands.
     *
     * @author Tahj Starr
     */

    /**
     * Adds a command to the command history.
     */
    void saveCommand(String command);

    /**
     * Sets the name displayed by CommandHistory based on the language to which GUI is set.
     */
    void setName(String name);

}
