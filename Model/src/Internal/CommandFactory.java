package Internal;
import External.Executable;

public interface CommandFactory {
    /**
     * Takes a command string and creates a Executable object
     * @param cmd A string that stands for the command
     * @param params A list of parameters for the command
     */
    public Executable createCommand(String cmd, List params);


}