package External;

import java.util.List;

public class StdModelTurtle implements ModelTurtle{
    private int TURTLE_ID = 0;
    private double myXPos = 0;
    private double myYPos = 0;
    private double myHeading = 0;
    private int penDown = 1;
    private int showing = 1;

    /**
     * Return a unique integer ID for this External.ModelTurtle. This method will be used in the event that multiple External.ModelTurtle
     * instances are created.
     *
     * @return the ID of this External.ModelTurtle
     */
    @Override
    public int getID() {
        return TURTLE_ID;
    }

    /**
     * @return a List of any variables representing the state of this External.ModelTurtle. The variables should be integers.
     */
    @Override
    public List<Integer> getState() {
        //FIXME: the variables I intended to return are now a mix of doubles and ints
        return List.of(); //this.getX(), this.getY(), this.getHeading(), this.getPenDown(), this.getShowing());
    }

    /**
     * Moves the External.ModelTurtle forward by the specified number of pixels.
     *
     * @param pixels the number of pixels the turtle should move
     * @return the number of pixels the turtle moved
     */
    @Override
    public double forward(double pixels) {
        double xDist = pixels*Math.cos(myHeading);
        double yDist = pixels*Math.sin(myHeading);
        myXPos += xDist;
        myYPos += yDist;
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
        return 0;
    }

    /**
     * Turns the turtle right by the specified number of degrees.
     *
     * @param degrees the number of degrees the turtle should turn
     * @return the number of degrees the turtle turned
     */
    @Override
    public double right(double degrees) {
        return 0;
    }

    /**
     * Sets the heading of the turtle as by the specified number degrees right of north/up.
     *
     * @param degrees the number of degrees right of north/up that the turtle's heading should be set to
     * @return the number of degrees the turtle turned
     */
    @Override
    public double setHeading(double degrees) {
        double diff = degrees - myHeading;
        myHeading = degrees;
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
        double xDiff = myXPos - x;
        double yDiff = myYPos - y;
        double newHeading = Math.tan(xDiff/yDiff);
        double headingDiff = newHeading - myHeading;
        myHeading = newHeading;
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
        double xDiff = myXPos - x;
        double yDiff = myYPos - y;
        myXPos = x;
        myYPos = y;
        return Math.sqrt(xDiff*xDiff + yDiff*yDiff);
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
     * puts pen up such that when the turtle moves, it does not leave a trail
     *
     * @return 0
     */
    @Override
    public int penUp() {
        penDown = 0;
        return penDown;
    }

    /**
     * makes turtle visible
     *
     * @return 1
     */
    @Override
    public int show() {
        showing = 1;
        return showing;
    }

    /**
     * makes turtle visible
     *
     * @return 0
     */
    @Override
    public int hide() {
        showing = 0;
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
        return home();
    }

    /**
     * @return the turtle's X coordinate, where the coordinates (0,0) are at the center of the screen
     */
    @Override
    public double getX() {
        return myXPos;
    }

    /**
     * @return the turtle's Y coordinate, where the coordinates (0,0) are at the center of the screen
     */
    @Override
    public double getY() {
        return myYPos;
    }

    /**
     * @return the turtle's heading as the number of degrees right of north/up
     */
    @Override
    public double getHeading() {
        return myHeading;
    }

    /**
     * @return 1 if turtle's pen is down, 0 if it is up
     */
    @Override
    public int getPenDown() {
        return penDown;
    }

    /**
     * @return 1 if turtle is showing, 0 if it is hiding
     */
    @Override
    public int getShowing() {
        return showing;
    }
}
