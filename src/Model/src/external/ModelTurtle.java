package external;

import java.util.Map;

/**
 * Instances of classes implementing this interface are abstract representations of a turtle
 * (i.e. a specific state could be displayed differently depending on how the view is implemented).
 * The methods in this interface provides access to the turtle's state And provide ways to modify that state.
 *
 * @author jgp17
 */
public interface ModelTurtle {

    //methods below are part of external Model API

    /**
     * Return a unique integer ID for this ModelTurtle. This method will be used in the event that multiple ModelTurtle
     * instances are created.
     *
     * @return the ID of this ModelTurtle
     */
    int getID();

    //methods below are part of internal Model API

    /**
     * @return a Map of any variables representing the state of this ModelTurtle And its ModelPen. The variables should
     * be doubles.
     */
    Map<String, Double> getState();

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
     * Turns the turtle Left by the specified number of degrees.
     *
     * @param degrees the number of degrees the turtle should turn
     * @return the number of degrees the turtle turned
     */
    double left(double degrees);

    /**
     * Turns the turtle Right by the specified number of degrees.
     *
     * @param degrees the number of degrees the turtle should turn
     * @return the number of degrees the turtle turned
     */
    double right(double degrees);

    /**
     * Sets the Heading of the turtle as by the specified number degrees Right of north/up.
     *
     * @param degrees the number of degrees Right of north/up that the turtle's Heading should be set to
     * @return the number of degrees the turtle turned
     */
    double setHeading(double degrees);

    /**
     * Sets the Heading of the turtle so that the turtle is facing the point (x,y), where (0,0) is the center of the
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
     * erases turtle's trails And sends it to the Home position
     *
     * @return the distance, in pixels, the turtle moved to get to the center of the screen
     */
    double clearScreen();

    /**
     * sets the index at which
     *
     * @param index the index at which the desired shape can be found in the list of possible shapes
     * @return the given index
     */
    int setShapeIndex(int index);

    /**
     * "activates" the ModelTurtle by setting a flag
     */
    void activate();

    /**
     * "deactivates" the ModelTurtle by setting a flag
     */
    void deactivate();

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
     * @return 	the turtle's Heading as the number of degrees Right of north/up
     */
    double getHeading();

    /**
     *
     * @return 1 if turtle is showing, 0 if it is hiding
     */
    int getShowing();

    /**
     * return the index at which the turtle's shape can be found in the list of possible shapes.
     * This list is a constant in the GUI.
     *
     * @return the index at which the turtle's shape can be found in the list of possible shapes
     */
    int getShapeIndex();

    /**
     * For Invoker to check whether to execute command
     *
     * @return true if turtle is active, false if it is not
     */
    boolean getActive();

    /**
     *
     * @return the ModelPen object associated with this ModelTurtle
     */
    ModelPen getPen();

    /**
     * returns the number of turtles that have been created, according to the static counter kept by the implementing
     * class.
     *
     * @return the number of turtles that have been created
     */
    int getNumTurtles();

    StdModelBackground getBackground();
}
