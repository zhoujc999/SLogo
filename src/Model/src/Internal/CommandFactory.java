package Internal;
import External.Executable;

public interface CommandFactory {

    public Executable createCommand(String cmd, List params);


}