package external;

import java.util.HashMap;
import java.util.Observable;

/**
 * The basic implementation of a ModelTurtle. Other implementations of ModelTurtle can extend this class to avoid
 * duplicating code. If other implementations wish to add additional variable representing state, they should override
 * the getState method.
 *
 * @author jgp17
 */

public class StdModelTurtle extends Observable implements ModelTurtle {
    public static final String OLD_XPOS_KEY = "oldXPos";
    public static final String OLD_YPOS_KEY = "oldYPos";
    public static final String XPOS_KEY = "xPos";
    public static final String YPOS_KEY = "yPos";
    public static final String SHAPE_INDEX_KEY = "shapeIndex";
    public static final String HEADING_KEY = "Heading";
    public static final String SHOWING_KEY = "showing";
    public static final String CLEARSCREEN_KEY = "ClearScreen";
    public static final String X_DISPLACEMENT_KEY = "xDisplacement";
    public static final String Y_DISPLACEMENT_KEY = "yDisplacement";
    public static final String ID_KEY = "ID";
    public static final String ACTIVE_KEY = "active";
    public static final int NINETY_DEGREES = 90;

    private static int numTurtles;
    private static StdModelBackground theBackground = new StdModelBackground();
    private int TURTLE_ID;
    private int shapeIndex;
    private double myXPos;
    private double myYPos;
    private double myHeading;
    private int showing;
    private int clearScreen;
    private boolean active;
    private ModelPen myPen;

    /**
     * Creates a StdModelTurtle with the desired id
     *
     * @param id the desired id of the StdModelTurtle to be created
     */

    public StdModelTurtle(int id) {
        numTurtles++;
        TURTLE_ID = id;
        shapeIndex = 0;
        myXPos = 0;
        myYPos = 0;
        myHeading = 0;
        showing = 1;
        clearScreen = 0;
        active = false;
        myPen = new StdModelPen();
    }

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


    private HashMap<String, Double> getOldXYMap() {
        HashMap<String, Double> map = new HashMap<>();
        map.put(OLD_XPOS_KEY, myXPos);
        map.put(OLD_YPOS_KEY, myYPos);
        return map;
    }

    /**
     * Returns a Map of any variables representing the state of this ModelTurtle And its ModelPen.
     * The variables should be doubles. Implementations extending this class that wish to add additional state
     * variables must override this method. Include a call to super.getState to access the Map returned below.
     *
     * @return a Map of any variables representing the state of this ModelTurtle And its ModelPen.
     */
    @Override
    public HashMap<String, Double> getState() {
        HashMap<String, Double> turtleState = new HashMap<>();
        turtleState.put(ID_KEY, (double) TURTLE_ID);
        turtleState.put(XPOS_KEY, myXPos);
        turtleState.put(YPOS_KEY, myYPos);
        turtleState.put(SHAPE_INDEX_KEY, (double) shapeIndex);
        turtleState.put(HEADING_KEY, myHeading);
        turtleState.put(SHOWING_KEY, (double) showing);
        turtleState.put(CLEARSCREEN_KEY, (double) clearScreen);
        turtleState.put(ACTIVE_KEY, getActiveAsDouble());
        turtleState.putAll(myPen.getState());
        turtleState.putAll(theBackground.getState());
        return turtleState;
    }

    private double getActiveAsDouble() {
        if (active) {
            return 1.0;
        }
        return 0.0;
    }

    public void notifyOfState(HashMap<String, Double> dataMap) {
        setChanged();
        dataMap.putAll(getState());
        dataMap.put(X_DISPLACEMENT_KEY, dataMap.get(XPOS_KEY) - dataMap.get(OLD_XPOS_KEY));
        dataMap.put(Y_DISPLACEMENT_KEY, dataMap.get(YPOS_KEY) - dataMap.get(OLD_YPOS_KEY));
        notifyObservers(dataMap);
        clearChanged();
    }

    /**
     * Moves the external.ModelTurtle Forward by the specified number of pixels.
     *
     * @param pixels the number of pixels the turtle should move
     * @return the number of pixels the turtle moved
     */
    @Override
    public double forward(double pixels) {
        HashMap<String, Double> dataMap = getOldXYMap();
        double xDist = pixels*Math.cos(Math.toRadians(myHeading - NINETY_DEGREES));
        double yDist = pixels*Math.sin(Math.toRadians(myHeading - NINETY_DEGREES));
        myXPos += xDist;
        myYPos += yDist;
        notifyOfState(dataMap);
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
     * Turns the turtle Left by the specified number of degrees.
     *
     * @param degrees the number of degrees the turtle should turn
     * @return the number of degrees the turtle turned
     */
    @Override
    public double left(double degrees) {
        return right(-degrees);
    }

    /**
     * Turns the turtle Right by the specified number of degrees.
     *
     * @param degrees the number of degrees the turtle should turn
     * @return the number of degrees the turtle turned
     */
    @Override
    public double right(double degrees) {
        HashMap<String, Double> dataMap = getOldXYMap();
        myHeading += degrees;
        notifyOfState(dataMap);
        return degrees;
    }

    /**
     * Sets the Heading of the turtle as by the specified number degrees Right of north/up.
     *
     * @param degrees the number of degrees Right of north/up that the turtle's Heading should be set to
     * @return the number of degrees the turtle turned
     */
    @Override
    public double setHeading(double degrees) {
        HashMap<String, Double> dataMap = getOldXYMap();
        double diff = degrees - myHeading;
        myHeading = degrees;
        notifyOfState(dataMap);
        return diff;
    }

    /**
     * Sets the Heading of the turtle so that the turtle is facing the point (x,y), where (0,0) is the center of the
     * screen.
     *
     * @param x the x-coordinate of the point the turtle should face
     * @param y the y-coordinate of the point the turtle should face
     * @return the number of degrees the turtle turned
     */
    @Override
    public double towards(double x, double y) {
        HashMap<String, Double> dataMap = getOldXYMap();
        double xDiff = myXPos - x;
        double yDiff = myYPos - y;
        double newHeading = Math.toDegrees(Math.atan(xDiff/yDiff)) + NINETY_DEGREES;
        double headingDiff = newHeading - myHeading;
        myHeading = newHeading;
        notifyOfState(dataMap);
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
        HashMap<String, Double> dataMap = getOldXYMap();
        double xDiff = myXPos - x;
        double yDiff = myYPos - y;
        myXPos = x;
        myYPos = y;
        double dist = Math.sqrt(xDiff*xDiff + yDiff*yDiff);
        notifyOfState(dataMap);
        return dist;
    }

    /**
     * makes turtle visible
     *
     * @return 1
     */
    @Override
    public int show() {
        HashMap<String, Double> dataMap = getOldXYMap();
        showing = 1;
        notifyOfState(dataMap);
        return showing;
    }

    /**
     * makes turtle visible
     *
     * @return 0
     */
    @Override
    public int hide() {
        HashMap<String, Double> dataMap = getOldXYMap();
        showing = 0;
        notifyOfState(dataMap);
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
     * erases turtle's trails And sends it to the Home position
     *
     * @return the distance, in pixels, the turtle moved to get to the center of the screen
     */
    @Override
    public double clearScreen() {
        clearScreen = 1;
        double dist = home(); //observers receive state within this call
        clearScreen = 0;
        return dist;
    }

    /**
     * sets the index at which
     *
     * @param index the index at which the desired shape can be found in the list of possible shapes
     * @return the given index
     */
    @Override
    public int setShapeIndex(int index) {
        shapeIndex = index;
        return shapeIndex;
    }

    public void activate() {
        active = true;
    }

    public void deactivate() {
        active = false;
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
     * @return the turtle's Heading as the number of degrees Right of north/up
     */
    @Override
    public double getHeading() {
        return myHeading;
    }

    /**
     * @return 1 if turtle is showing, 0 if it is hiding
     */
    @Override
    public int getShowing() {
        return showing;
    }

    /**
     * return the index at which the turtle's shape can be found in the list of possible shapes.
     * This list is a constant in the GUI.
     *
     * @return the index at which the turtle's shape can be found in the list of possible shapes
     */
    @Override
    public int getShapeIndex() {
        return shapeIndex;
    }

    /**
     * For Invoker to check whether to execute command
     *
     * @return 1 if turtle is active, 0 if it is not
     */
    @Override
    public boolean getActive() {
        return active;
    }

    /**
     * @return the ModelPen object associated with this ModelTurtle
     */
    @Override
    public ModelPen getPen() {
        return myPen;
    }

    public int getNumTurtles() {
        return numTurtles;
    }

    public StdModelBackground getBackground() {
        return theBackground;
    }
}
