package commandFactory;

import commands.CommandTextWrapper;
import commands.GenericCommand;
import external.Invokable;
import external.SLogoExecutable;
import external.VariableAccessor;

import java.util.List;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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

            catch (InstantiationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        if (command == null) {
            throw new NullPointerException("Command Object is null");
        }
        invoker.acceptCommand(command);
    }
}


