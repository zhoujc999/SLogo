package external;

import java.util.Map;

public interface ModelPen {
    //methods below are part of external Model API

    /**
     * Returns the return value from the last method called on this ModelPen so that the Parser can parse any
     * commands that require this return value.
     *
     * @return the return value from the last method called on this ModelPen.
     */
    double getReturnVal();

    //methods below are part of internal Model API

    /**
     * @return a Map of any variables representing the state of this ModelPen. The variables should be doubles.
     */
    Map<String, Double> getState();

    /**
     * puts pen down such that when the turtle moves, it leaves a trail
     *
     * @return 1
     */
    int penDown();

    /**
     * puts pen up such that when the turtle moves, it does not leave a trail
     *
     * @return 0
     */
    int penUp();

    /**
     * Set the pen color based on the specified int, returns that int.
     * 0 black
     *
     * @return an int representing the pen color.
     */
    int setColor(int color);

    /**
     * Sets the pen width based on the specified double, returns that double.
     *
     * @return the specified width.
     */

    double setWidth(double width);

    /**
     *
     * @return 1 if turtle's pen is down, 0 if it is up
     */
    int getPenDown();

    /**
     * @return an int representing the pen color.
     */
    int getColor();

    /**
     * @return the current pen width.
     */
    double getWidth();


}
