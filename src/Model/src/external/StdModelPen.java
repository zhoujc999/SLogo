package external;

import java.util.HashMap;

/**
 * The basic implementation of a ModelPen. Other implementations of ModelPen can extend this class to avoid
 * duplicating code. If other implementations wish to add additional variable representing state, they should override
 * the getState method.
 *
 * @author jgp17
 */

public class StdModelPen extends StdColorObject implements ModelPen {
    public static final String PEN_DOWN_KEY = "PenDown";
    public static final String PEN_SIZE_KEY = "penSize";
    private int penDown;
    private double size;

    public StdModelPen() {
        penDown = 1;
        size = 5;
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
     * puts pen down such that when the turtle moves, it leaves a trail
     *
     * @return 1
     */
    @Override
    public int penDown() {
            penDown = 1;
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
        return size;
    }

    /**
     * @return 1 if turtle's pen is down, 0 if it is up
     */
    @Override
    public int getPenDown() {
        return penDown;
    }

    /**
     * @return the current pen size, in pixels.
     */
    @Override
    public double getSize() {
        return size;
    }
}
