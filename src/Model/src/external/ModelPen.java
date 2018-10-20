package external;

import java.util.Map;

/**
 * Instances of classes implementing this interface are abstract representations of a pen
 * (i.e. a specific state could be displayed differently depending on how the view is implemented).
 * The methods in this interface provides access to the pen's state and provide ways to modify that state.
 * Each ModelTurtle will have its own ModelPen.
 *
 * @author jgp17
 */

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
     * Sets the pen size based on the specified double number of pixels, returns that double.
     *
     * @return the specified size, in number of pixels.
     */

    double setSize (double pixels);

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
     * @return the current pen size, in pixels.
     */
    double getSize();


}
