package internal;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class TurtleView extends ImageView {
    /**
     * The TurtleView is the graphical representation of the turtle. It is able to move and interact with the graphics
     * window. It needs access to various image files to set/change its image.
     *
     * @author Tahj Starr
     */

    private static final double ACTIVE_SIZE = 50;
    private static final double INACTIVE_SIZE = 25;

    private double mySize;
    private int myID;
    private boolean isActive;

    public TurtleView(String url, double x, double y, int id) {
        super(url);
        mySize = ACTIVE_SIZE;
        setFitWidth(mySize);
        setFitHeight(mySize);
        setPosition(x, y);
        myID = id;
        isActive = true;
        addEventHandler(MouseEvent.MOUSE_CLICKED, e -> toggleActivation());
    }

    private void toggleActivation() {
        if (isActive) {
            System.out.println(getLayoutX());
            deactivate();
        } else {
            System.out.println(getLayoutX());
            activate();
        }
    }

    /**
     * Sets turtle's active status to the given boolean.
     */
    public void setActiveStatus(boolean status) {
        isActive = status;
    }

    private void activate() {
        isActive = true;
        setNewSize(ACTIVE_SIZE);
    }

    private void deactivate() {
        isActive = false;
        setNewSize(INACTIVE_SIZE);
    }

    private void setNewSize(double size) {
        double x = getTurtleX();
        double y = getTurtleY();
        mySize = size;
        setFitWidth(size);
        setFitHeight(size);
        setPosition(x, y);
    }

    protected double getTurtleX() {
        return getLayoutX() + mySize /2;
    }

    protected double getTurtleY() {
        return getLayoutY() + mySize /2;
    }

    /**
     * Sets center of the TurtleView to given x and y coordinates.
     */
    public void setPosition(double x, double y) {
        relocate(x - mySize /2, y - mySize /2);
    }

}
