package Model.src;


import java.util.List;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import Model.src.External.*;

public class CommandFactory {

    private Invoker invoker;
    private static CommandFactory cmdFactory;


    private CommandFactory(Invoker invoker) {
        this.invoker = invoker;
    }

    public static CommandFactory getInstance(Invoker invoker) {
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
        String commandName = "src.Model.src.Commands." + cmd;
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


