package CommandFactory;

import External.Invokable;
import External.SLogoExecutable;
import Internal.CommandFactoryInterface;
import java.util.List;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CommandFactory implements CommandFactoryInterface {

    private Invokable invoker;
    private static CommandFactory cmdFactory;


    private CommandFactory(Invokable invoker) {
        this.invoker = invoker;
    }

    public CommandFactory getInstance(Invokable invoker) {
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


