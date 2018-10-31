package external;

import java.util.HashMap;

public class StdModelBackground extends StdColorObject{

    public StdModelBackground() {
        super();
        setColor(7);
    }

    public HashMap<String, Double> getState() {
        HashMap<String, Double> stateMap = new HashMap<>();
        stateMap.putAll(super.getState("bg"));
        return stateMap;
    }
}
