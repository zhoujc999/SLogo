package gui;

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
    private Color myPenColor;

    protected TurtleView(String url, double x, double y, int id) {
        super(url);
        mySize = ACTIVE_SIZE;
        setFitWidth(mySize);
        setFitHeight(mySize);
        setPosition(x, y);
        myID = id;
        addEventHandler(MouseEvent.MOUSE_CLICKED, e -> toggleActivation());
        myPenColor = Color.BLACK;
    }

    private void toggleActivation() {
        var window = (GraphicsWindow) getParent();
        if (window.getTurtles().contains(this)) {
            System.out.println(getLayoutX());
            deactivate();
        } else {
            System.out.println(getLayoutX());
            activate();
        }
    }

    protected TurtleView(String url) {
        super(url);
        setFitWidth(mySize);
        setFitHeight(mySize);
        myPenColor = Color.BLACK;
    }

    protected void move(double dx, double dy) {
        setPosition(getTurtleX() + dx, getTurtleY() + dy);
    }

    protected void activate() {
        var window = (GraphicsWindow) getParent();
        window.getTurtles().add(this);
        setNewSize(ACTIVE_SIZE);
    }

    protected void deactivate() {
        var window = (GraphicsWindow) getParent();
        window.getTurtles().remove(this);
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

    protected void setPosition(double x, double y) {
        relocate(x - mySize /2, y - mySize /2);
    }

    protected Color getPenColor() {
        return myPenColor;
    }

    protected void setPenColor(Color color) {
        myPenColor = color;
    }

}
