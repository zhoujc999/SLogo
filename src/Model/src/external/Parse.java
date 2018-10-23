package external;

/**
 * An interface used by classes that parse strings into individual procedure calls and arguments.
 * This interface is designed such that the commands are not returned.
 * Therefore, construction of commands and execution of commands must occur from calls in the implementing class.
 */

import java.util.Observable;
import java.util.Observer;

public interface Parse extends Observer {

    /**
     * Takes a string and parses it into all sub commands and executes those sub commands
     * @param cmd A string that stands for the commands to be executed
     */

    public void parseCommand(String cmd);

    /**
     * Substitutes the given value for the command just executed
     * An implementation of observer abstract method.
     * Called when the corresponding observable is updated.
     *
     * @param o The corresponding obserable
     * @param arg The value that is returned by the last executed command
     */

    public void update(Observable o, Object arg);

    /**
     * Changes the language that the Parser recognizes for commands
     * @param lang The new language
     */

    public void setReplacementValue(String s);

    public void changeLanguage(String lang);

    /**
     * Adds a variable to the map of variables that the parser recognizes
     * @param name The name of the variable being added
     * @param value The value mapped to the variable
     */
    public void addVariable(String name, String value);

}
