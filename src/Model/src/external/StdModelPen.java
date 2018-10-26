package external;

import java.util.Map;

/**
 * The basic implementation of a ModelPen. Other implementations of ModelPen can extend this class to avoid
 * duplicating code. If other implementations wish to add additional variable representing state, they should override
 * the getState method.
 *
 * @author jgp17
 */

public class StdModelPen implements ModelPen {
    public static final String PEN_DOWN_KEY = "penDown";
    public static final String PEN_COLOR_KEY = "penColor";
    public static final String PEN_SIZE_KEY = "penSize";
    private double returnVal;
    private int penDown;
    private int myColor;
    private double mySize;

    public StdModelPen() {
        penDown = 1;
        myColor = 0;
        mySize = 10;
    }


    /**
     * Returns a Map of any variables representing the state of this ModelPen. The variables should be doubles.
     * Implementations extending this class that wish to add additional state variables must override this
     * method. Include a call to super.getState to access the Map returned below.
     *
     * @return a Map of any variables representing the state of this ModelPen.
     */
    @Override
    public Map<String, Double> getState() {
        return Map.ofEntries(
                Map.entry(PEN_DOWN_KEY, (double) penDown),
                Map.entry(PEN_COLOR_KEY, (double) myColor),
                Map.entry(PEN_SIZE_KEY, mySize));
    }

    /**
     * Returns the return value from the last method called on this ModelPen so that the Parser can parse any
     * commands that require this return value.
     *
     * @return the return value from the last method called on this ModelPen.
     */
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
     * puts pen up such that when the turtle moves, it does not leave a trail
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
     * Set the pen color based on the specified int, returns that int.
     * 0 black
     *
     * @param color
     * @return an int representing the pen color.
     */
    @Override
    public int setColor(int color) {
        myColor = color;
        returnVal = myColor;
        return myColor;
    }

    /**
     * Sets the pen size based on the specified double number of pixels, returns that double.
     *
     * @param
     * @return the specified size, in number of pixels.
     */
    @Override
    public double setSize(double pixels) {
        mySize = pixels;
        returnVal = mySize;
        return mySize;
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
     * @return an int representing the pen color.
     */
    @Override
    public int getColor() {
        returnVal = myColor;
        return myColor;
    }

    /**
     * @return the current pen size, in pixels.
     */
    @Override
    public double getSize() {
        returnVal = mySize;
        return mySize;
    }
}
