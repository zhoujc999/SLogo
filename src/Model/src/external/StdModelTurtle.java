package external;

import java.util.Map;
import java.util.Observable;

public class StdModelTurtle extends Observable implements ModelTurtle {
    private int TURTLE_ID = 0;
    private double myXPos = 0;
    private double myYPos = 0;
    private double myHeading = 0;
    private int penDown = 1;
    private int showing = 1;
    private int clearScreen = 0;
    private double returnVal;

    /**
     * Return a unique integer ID for this external.ModelTurtle. This method will be used in the event that multiple external.ModelTurtle
     * instances are created.
     *
     * @return the ID of this external.ModelTurtle
     */
    @Override
    public int getID() {
        return TURTLE_ID;
    }

    public double getReturnVal() {
        return returnVal;
    }

    private void notifyGivenStates(Map<String, Double> oldState, Map<String, Double> newState) {
        notifyObservers(Map.of("oldState", oldState, "newState", newState));
    }

    /**
     * @return a List of any variables representing the state of this external.ModelTurtle. The variables should be integers.
     */
    @Override
    public Map<String, Double> getState() {
        return Map.ofEntries(
                Map.entry("xPos", myXPos),
                Map.entry("yPos", myYPos),
                Map.entry("heading", myHeading),
                Map.entry("penDown", (double) penDown),
                Map.entry("showing", (double) showing),
                Map.entry("clearScreen", (double) clearScreen));
    }

    /**
     * Moves the external.ModelTurtle forward by the specified number of pixels.
     *
     * @param pixels the number of pixels the turtle should move
     * @return the number of pixels the turtle moved
     */
    @Override
    public double forward(double pixels) {
        var oldState = getState();
        double xDist = pixels*Math.cos(myHeading);
        double yDist = pixels*Math.sin(myHeading);
        myXPos += xDist;
        myYPos += yDist;
        returnVal = pixels;
        var newState = getState();
        notifyGivenStates(oldState, newState);
        return pixels;
    }

    /**
     * Moves the turtle backward by the specified number of pixels.
     *
     * @param pixels the number of pixels the turtle should move
     * @return the number of pixels the turtle moved
     */
    @Override
    public double back(double pixels) {
        return forward(-pixels);
    }

    /**
     * Turns the turtle left by the specified number of degrees.
     *
     * @param degrees the number of degrees the turtle should turn
     * @return the number of degrees the turtle turned
     */
    @Override
    public double left(double degrees) {
        return right(-degrees);
    }

    /**
     * Turns the turtle right by the specified number of degrees.
     *
     * @param degrees the number of degrees the turtle should turn
     * @return the number of degrees the turtle turned
     */
    @Override
    public double right(double degrees) {
        var oldState = getState();
        myHeading += degrees;
        returnVal = degrees;
        var newState = getState();
        notifyGivenStates(oldState, newState);
        return degrees;
    }

    /**
     * Sets the heading of the turtle as by the specified number degrees right of north/up.
     *
     * @param degrees the number of degrees right of north/up that the turtle's heading should be set to
     * @return the number of degrees the turtle turned
     */
    @Override
    public double setHeading(double degrees) {
        var oldState = getState();
        double diff = degrees - myHeading;
        myHeading = degrees;
        returnVal = diff;
        var newState = getState();
        notifyGivenStates(oldState, newState);
        return diff;
    }

    /**
     * Sets the heading of the turtle so that the turtle is facing the point (x,y), where (0,0) is the center of the
     * screen.
     *
     * @param x the x-coordinate of the point the turtle should face
     * @param y the y-coordinate of the point the turtle should face
     * @return the number of degrees the turtle turned
     */
    @Override
    public double towards(double x, double y) {
        var oldState = getState();
        double xDiff = myXPos - x;
        double yDiff = myYPos - y;
        double newHeading = Math.tan(xDiff/yDiff);
        double headingDiff = newHeading - myHeading;
        myHeading = newHeading;
        returnVal = headingDiff;
        var newState = getState();
        notifyGivenStates(oldState, newState);
        return headingDiff;
    }

    /**
     * Sets the position of the turtle the absolute screen position with coordinates (x,y), where (0,0) is the center
     * of the screen.
     *
     * @param x the x-coordinate of the desired position of the turtle
     * @param y the x-coordinate of the desired position of the turtle
     * @return the distance, in pixels, travelled by the turtle to reach the desired position
     */
    @Override
    public double goTo(double x, double y) {
        var oldState = getState();
        double xDiff = myXPos - x;
        double yDiff = myYPos - y;
        myXPos = x;
        myYPos = y;
        double dist = Math.sqrt(xDiff*xDiff + yDiff*yDiff);
        returnVal = dist;
        var newState = getState();
        notifyGivenStates(oldState, newState);
        return dist;
    }

    /**
     * puts pen down such that when the turtle moves, it leaves a trail
     *
     * @return 1
     */
    @Override
    public int penDown() {
        var oldState = getState();
        penDown = 1;
        returnVal = penDown;
        var newState = getState();
        notifyGivenStates(oldState, newState);
        return penDown;
    }

    /**
     * puts pen up such that when the turtle moves, it does not leave a trail
     *
     * @return 0
     */
    @Override
    public int penUp() {
        var oldState = getState();
        penDown = 0;
        returnVal = penDown;
        var newState = getState();
        notifyGivenStates(oldState, newState);
        return penDown;
    }

    /**
     * makes turtle visible
     *
     * @return 1
     */
    @Override
    public int show() {
        var oldState = getState();
        showing = 1;
        returnVal = showing;
        var newState = getState();
        notifyGivenStates(oldState, newState);
        return showing;
    }

    /**
     * makes turtle visible
     *
     * @return 0
     */
    @Override
    public int hide() {
        var oldState = getState();
        showing = 0;
        returnVal = showing;
        var newState = getState();
        notifyGivenStates(oldState, newState);
        return showing;
    }

    /**
     * moves turtle to the center of the screen (0,0)
     *
     * @return the distance, in pixels, the turtle moved to get to the center of the screen
     */
    @Override
    public double home() {
        return goTo(0,0);
    }

    /**
     * erases turtle's trails and sends it to the home position
     *
     * @return the distance, in pixels, the turtle moved to get to the center of the screen
     */
    @Override
    public double clearScreen() {
        //FIXME: Notify observers correctly
        clearScreen = 1;
        return home();
    }

    /**
     * @return the turtle's X coordinate, where the coordinates (0,0) are at the center of the screen
     */
    @Override
    public double getX() {
        returnVal = myXPos;
        return myXPos;
    }

    /**
     * @return the turtle's Y coordinate, where the coordinates (0,0) are at the center of the screen
     */
    @Override
    public double getY() {
        returnVal = myYPos;
        return myYPos;
    }

    /**
     * @return the turtle's heading as the number of degrees right of north/up
     */
    @Override
    public double getHeading() {
        returnVal = myHeading;
        return myHeading;
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
     * @return 1 if turtle is showing, 0 if it is hiding
     */
    @Override
    public int getShowing() {
        returnVal = showing;
        return showing;
    }
}
