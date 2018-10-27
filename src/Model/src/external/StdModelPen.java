package external;

import java.util.HashMap;
import java.util.Map;

/**
 * The basic implementation of a ModelPen. Other implementations of ModelPen can extend this class to avoid
 * duplicating code. If other implementations wish to add additional variable representing state, they should override
 * the getState method.
 *
 * @author jgp17
 */

public class StdModelPen extends StdColorObject implements ModelPen {
    public static final String PEN_DOWN_KEY = "PenDown";
    public static final String PEN_COLOR_INDEX_KEY = "penColorIndex";
    public static final String PEN_COLOR_R_KEY = "penColorRVal";
    public static final String PEN_COLOR_G_KEY = "penColorGVal";
    public static final String PEN_COLOR_B_KEY = "penColorBVal";
    public static final String PEN_SIZE_KEY = "penSize";
    private double returnVal;
    private int penDown;
    private static int penColorIndex = 0;
    private static double size = 10;
    private static int bgColorIndex = 7;

    public StdModelPen() {
        penDown = 1;
    }


    /**
     * Returns a Map of any variables representing the state of this ModelPen. The variables should be doubles.
     * Implementations extending this class that wish to add additional state variables must override this
     * method. Include a call to super.getState to access the Map returned below.
     *
     * @return a Map of any variables representing the state of this ModelPen.
     */
    @Override
    public HashMap<String, Double> getState() {
         HashMap<String, Double> stateMap = new HashMap<>();
         stateMap.put(PEN_DOWN_KEY, (double) penDown);
         stateMap.put(PEN_SIZE_KEY, size);
         stateMap.putAll(super.getState("pen"));
         return stateMap;
    }

    /**
     * Returns the return value from the last method called on this ModelPen so that the Parser can parse any
     * commands that require this return value.
     *
     * @return the return value from the last method called on this ModelPen.
     */
    @Override
    public double getReturnVal() {
        return returnVal;
    }

    /**
     * puts pen down such that when the turtle moves, it leaves a trail
     *
     * @return 1
     */
    @Override
    public int penDown() {
            penDown = 1;
            returnVal = penDown;
            return penDown;
    }

    /**
     * puts pen up such that when the turtle moves, it does Not leave a trail
     *
     * @return 0
     */
    @Override
    public int penUp() {
        penDown = 0;
        returnVal = penDown;
        return penDown;
    }

    /**
     * Sets the pen size based on the specified double number of pixels, returns that double.
     *
     * @param
     * @return the specified size, in number of pixels.
     */
    @Override
    public double setSize(double pixels) {
        size = pixels;
        returnVal = size;
        return size;
    }

    /**
     * Set the pen color based on the specified int, returns that int.
     *
     * @param colorIndex
     * @return an int representing the pen color.
     */
    @Override
    public int setColor(int colorIndex) {
        int index = super.setColor(colorIndex);
        returnVal = index;
        return index;
    }

    /**
     * @return 1 if turtle's pen is down, 0 if it is up
     */
    @Override
    public int getPenDown() {
        returnVal = penDown;
        return penDown;
    }

    /**
     * @return the current pen size, in pixels.
     */
    @Override
    public double getSize() {
        returnVal = size;
        return size;
    }

    @Override
    public int getColor() {
        int index = super.getColor();
        returnVal = index;
        return index;
    }
}
