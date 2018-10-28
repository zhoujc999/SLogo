package external;

import java.util.Map;
import java.util.function.Consumer;

/**
 * Instances of classes implementing this interface are abstract representations of a pen
 * (i.e. a specific state could be displayed differently depending on how the view is implemented).
 * The methods in this interface provides access to the pen's state And provide ways to modify that state.
 * Each ModelTurtle will have its own ModelPen.
 *
 * @author jgp17
 */

public interface ModelPen extends ColorObject{

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
     * puts pen up such that when the turtle moves, it does Not leave a trail
     *
     * @return 0
     */
    int penUp();

    /**
     * Sets the pen size based on the specified double number of pixels, returns that double.
     *
     * @param pixels the desired size, in pixels
     * @return the specified size, in number of pixels.
     */

    double setSize (double pixels);

    /**
     *
     * @return 1 if turtle's pen is down, 0 if it is up
     */
    int getPenDown();

    /**
     * @return the current pen size, in pixels.
     */
    double getSize();

}
