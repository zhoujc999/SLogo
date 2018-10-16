package external;

import java.util.List;
import java.util.Map;

/**
 * Instances of classes implementing this interface are abstract representations of a turtle
 * (i.e. a specific state could be displayed differently depending on how the view is implemented).
 * The methods in this interface provides access to the turtle's state and provide ways to modify that state.
 */
public interface ModelTurtle {

    //methods below are part of external Model API

    /**
     * Return a unique integer ID for this external.ModelTurtle. This method will be used in the event that multiple external.ModelTurtle
     * instances are created.
     *
     * @return the ID of this external.ModelTurtle
     */
    int getID();

    /**
     * @return a List of any variables representing the state of this external.ModelTurtle. The variables should be integers.
     */
    Map<String, Double> getState();

    //methods below are part of internal Model API

    /**
     * Moves the external.ModelTurtle forward by the specified number of pixels.
     *
     * @param pixels the number of pixels the turtle should move
     * @return the number of pixels the turtle moved
     */
    double forward(double pixels);

    /**
     * Moves the turtle backward by the specified number of pixels.
     *
     * @param pixels the number of pixels the turtle should move
     * @return the number of pixels the turtle moved
     */
    double back(double pixels);

    /**
     * Turns the turtle left by the specified number of degrees.
     *
     * @param degrees the number of degrees the turtle should turn
     * @return the number of degrees the turtle turned
     */
    double left(double degrees);

    /**
     * Turns the turtle right by the specified number of degrees.
     *
     * @param degrees the number of degrees the turtle should turn
     * @return the number of degrees the turtle turned
     */
    double right(double degrees);

    /**
     * Sets the heading of the turtle as by the specified number degrees right of north/up.
     *
     * @param degrees the number of degrees right of north/up that the turtle's heading should be set to
     * @return the number of degrees the turtle turned
     */
    double setHeading(double degrees);

    /**
     * Sets the heading of the turtle so that the turtle is facing the point (x,y), where (0,0) is the center of the
     * screen.
     *
     * @param x the x-coordinate of the point the turtle should face
     * @param y the y-coordinate of the point the turtle should face
     * @return the number of degrees the turtle turned
     */
    double towards(double x, double y);

    /**
     * Sets the position of the turtle the absolute screen position with coordinates (x,y), where (0,0) is the center
     * of the screen.
     *
     * @param x the x-coordinate of the desired position of the turtle
     * @param y the x-coordinate of the desired position of the turtle
     * @return the distance, in pixels, travelled by the turtle to reach the desired position
     */
    double goTo(double x, double y);

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
     * makes turtle visible
     *
     * @return 1
     */
    int show();

    /**
     * makes turtle visible
     *
     * @return 0
     */
    int hide();

    /**
     * moves turtle to the center of the screen (0,0)
     *
     * @return the distance, in pixels, the turtle moved to get to the center of the screen
     */
    double home();

    /**
     * erases turtle's trails and sends it to the home position
     *
     * @return the distance, in pixels, the turtle moved to get to the center of the screen
     */
    double clearScreen();

    /**
     *
     * @return the turtle's X coordinate, where the coordinates (0,0) are at the center of the screen
     */
    double getX();

    /**
     *
     * @return the turtle's Y coordinate, where the coordinates (0,0) are at the center of the screen
     */
    double getY();

    /**
     *
     * @return 	the turtle's heading as the number of degrees right of north/up
     */
    double getHeading();

    /**
     *
     * @return 1 if turtle's pen is down, 0 if it is up
     */
    int getPenDown();

    /**
     *
     * @return 1 if turtle is showing, 0 if it is hiding
     */
    int getShowing();
}
