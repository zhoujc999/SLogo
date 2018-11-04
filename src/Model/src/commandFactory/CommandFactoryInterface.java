package commandFactory;

import java.util.List;

/**
 * CommandFactoryInterface is the abstraction of the CommandFactory class.
 * It only has a single method - createCommand, which is called by the Parser.
 * WHen createCommand is called, a Command object which implements SLogoExecutable will be created and passed to the Invoker.
 * These Command Objects interact with the Model Turtle, Invoker and  parts of the Parser depending on the specific command.
 * When passed the String of a command, the Command would look for a User-defined command through the variableAccessor interface.
 * If the command exists, it instantiates a GenericCommand object and passes the object to the Invoker.
 * Else, the CommandFactory tries to instantiate the corresponding Command object.
 * If Java Reflection throws an exception, CommandFactory throws a RuntimeException.
 * @author Jason Zhou
 */

public interface CommandFactoryInterface {
    /**
     * Takes a command string And creates a SLogoExecutable object
     * @param cmd A string that stands for the command
     * @param params A list of parameters for the command in Strings
     */
    public void createCommand(String cmd, List params);
}