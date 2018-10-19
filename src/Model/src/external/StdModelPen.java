package external;

import java.util.Map;

public class StdModelPen implements ModelPen {
    private double returnVal;
    private int penDown;
    private int myColor;
    private double myWidth;


    /**
     * @return a Map of any variables representing the state of this ModelPen. The variables should be doubles.
     */
    @Override
    public Map<String, Double> getState() {
        return Map.ofEntries(
                Map.entry("penDown", (double) penDown),
                Map.entry("penColor", (double) myColor),
                Map.entry("penWidth", myWidth));
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
        penDown = 1;
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
     * Sets the pen width based on the specified double, returns that double.
     *
     * @param width
     * @return the specified width.
     */
    @Override
    public double setWidth(double width) {
        myWidth = width;
        returnVal = myWidth;
        return myWidth;
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
     * @return the current pen width.
     */
    @Override
    public double getWidth() {
        returnVal = myWidth;
        return myWidth;
    }
}
