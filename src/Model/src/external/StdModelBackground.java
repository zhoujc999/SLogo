package external;

import java.util.HashMap;

public class StdModelBackground extends StdColorObject{

    private double returnVal;

    public StdModelBackground() {
        super();
        setColor(3);
    }

    public HashMap<String, Double> getState() {
        HashMap<String, Double> stateMap = new HashMap<>();
        stateMap.putAll(super.getState("bg"));
        return stateMap;
    }

    /**
     * Returns the return value from the last method called on this ColorObject so that the Parser can parse any
     * commands that require this return value.
     *
     * @return the return value from the last method called on this ModelPen.
     */
    @Override
    public double getReturnVal() {
        return returnVal;
    }

    /**
     * Sets the background color to the color in the palette at the specified int index, returns that int.
     *
     * @param colorIndex the index of the desired color in the palette
     * @return an int representing the pen color.
     */
    @Override
    public int setColor(int colorIndex) {
        int index = super.setColor(colorIndex);
        returnVal = index;
        return index;
    }

    @Override
    public int getColor() {
        int index = super.getColor();
        returnVal = index;
        return index;
    }
}
