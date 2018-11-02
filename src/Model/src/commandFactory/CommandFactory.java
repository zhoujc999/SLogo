package commandFactory;

import commands.CommandTextWrapper;
import commands.GenericCommand;
import external.Invokable;
import external.SLogoExecutable;
import external.VariableAccessor;

import java.util.List;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * The CommandFactory class uses Java Reflection to instantiate Command objects with Strings.
 * These Command Objects interact with the Model Turtle, Invoker and  parts of the Parser depending on the specific command.
 * When passed the String of a command, the CommandFactory would look for a User-defined command through the variableAccessor interface.
 * If the command exists, it instantiates a GenericCommand object and passes the object to the Invoker.
 * Else, the CommandFactory tries to instantiate the corresponding Command object.
 * If Java Reflection throws an exception, CommandFactory throws a RuntimeException.
 * @author Jason Zhou
 */

public class CommandFactory implements CommandFactoryInterface {

    private Invokable invoker;
    private VariableAccessor variableAccessor;


    public CommandFactory(Invokable invoker, VariableAccessor variableAccessor) {
        this.invoker = invoker;
        this.variableAccessor = variableAccessor;
    }





    final public void createCommand(String cmd, List params) {
//        System.out.println("cmd");
//        System.out.println(cmd);
//        System.out.println("param list");
//        System.out.println(params);

        SLogoExecutable command = null;
        CommandTextWrapper commandTextWrapper = variableAccessor.getCommand(cmd);

        if (commandTextWrapper != null) {
            command = new GenericCommand(params, commandTextWrapper);
        }
        else {
            String commandName = "commands." + cmd;
            Class<?> commandClass = null;
            try {
                commandClass = Class.forName(commandName);
            }
            catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            Constructor<?> constructor = commandClass.getConstructors()[0];

            try {
                command = (SLogoExecutable) constructor.newInstance(params);
            }

            catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                throw new RuntimeException("Command Instantiation Exception");
            }
        }

        if (command == null) {
            throw new NullPointerException("Command Object is null");
        }
        invoker.acceptCommand(command);
    }
}


