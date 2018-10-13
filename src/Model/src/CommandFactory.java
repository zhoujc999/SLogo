import java.util.List;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import external.Executable;

public class CommandFactory {

    private static CommandFactory cmdFactory;
    private static CommandInvoker invoker;

    private CommandFactory(CommandInvoker invoker) {
        this.invoker = invoker;
    }

    public static CommandFactory getInstance(CommandInvoker invoker) {
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



    public void createCommand(String cmd, List params) {
        String commandName = "Commands." + cmd;
        Class<?> commandClass = null;
        try {
            commandClass = Class.forName(commandName);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Constructor<?> constructor = commandClass.getConstructors()[0];
        Executable executable = null;

        try {
            executable = (Executable) constructor.newInstance();
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
}


