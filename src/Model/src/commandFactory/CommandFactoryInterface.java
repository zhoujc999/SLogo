package commandFactory;

import external.Invokable;
import java.util.List;

public interface CommandFactoryInterface {


    /**
     * Takes a command string And creates a SLogoExecutable object
     * @param cmd A string that stands for the command
     * @param params A list of parameters for the command
     */
    public void createCommand(String cmd, List params);


}