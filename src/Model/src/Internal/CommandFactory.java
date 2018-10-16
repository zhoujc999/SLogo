package Internal;
import external.Executable;
import java.util.List;

public interface CommandFactory {

    /**
     * Instantiates a Singleton CommandFactory
     * @param invoker
     */
    public CommandFactory getInstance(Invoker invoker);

    /**
     * Takes a command string and creates a SLogoExecutable object
     * @param cmd A string that stands for the command
     * @param params A list of parameters for the command
     */
    public Executable createCommand(String cmd, List params);


}