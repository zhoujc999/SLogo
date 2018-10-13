package external;

import java.util.Observable;

public interface Parse {

    public void parseCommand(String cmd);

    public void update(Observable o, Object arg);

}
