package commandFactory;

import external.Invokable;
import external.SLogoExecutable;

import java.util.List;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CommandFactory {

    private static CommandFactory cmdFactory;
    private Invokable invoker;


    private CommandFactory(Invokable invoker) {
        this.invoker = invoker;
    }

    public static CommandFactory getInstance(Invokable invoker) {
        if (cmdFactory == null)
        {
            synchronized(CommandFactory.class)
            {
                if (cmdFactory == null)
                {
                    cmdFactory = new CommandFactory(invoker);
                }
            }
        }

        return cmdFactory;
    }



    final public void createCommand(String cmd, List params) {
        String commandName = "src.Model.src.commands." + cmd;
        Class<?> commandClass = null;
        try {
            commandClass = Class.forName(commandName);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Constructor<?> constructor = commandClass.getConstructors()[0];
        SLogoExecutable command = null;

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
        if (command == null) {
            throw new NullPointerException("Command Object is null");
        }
        invoker.acceptCommand(command);
    }
}


