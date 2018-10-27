package commandFactory;

import external.Invokable;
import external.SLogoExecutable;

import java.util.List;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CommandFactory implements CommandFactoryInterface {

    private Invokable invoker;


    public CommandFactory(Invokable invoker) {
        this.invoker = invoker;
    }





    final public void createCommand(String cmd, List params) {
        System.out.println("cmd");
        System.out.println(cmd);
        System.out.println("param list");
        System.out.println(params);
        String commandName = "commands." + cmd;
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


