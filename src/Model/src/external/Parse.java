package external;

/**
 * An interface used by classes that parse strings into individual procedure calls And arguments.
 * This interface is designed such that the commands are Not returned.
 * Therefore, construction of commands And execution of commands must occur from calls in the implementing class.
 */

import java.util.Observable;
import java.util.Observer;

public interface Parse extends Observer {

    /**
     * Takes a string And parses it into all sub commands And executes those sub commands
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
     * Allows access to view variables
     * @return a variable accessor interface
     */
    public VariableAccessor getVariableAccessor();

    /**
     * Allows access to changing the language used
     * @return a language interface
     */
    public LanguageInterface getLanguageInterface();

}
