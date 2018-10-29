package gui;

import internal.TurtleView;
import javafx.geometry.Dimension2D;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;

import java.util.*;

/**
 * @author Tahj Starr
 * @author jgp17
 */

public class GraphicsWindow extends Pane implements Observer {
    /**
     * GraphicsWindow contains the turtle. The turtles may in a list if multiple turtles want to be added.
     */


    private static final Dimension2D SIZE = new Dimension2D(580, 540);
    public static final String DEFAULT_FILENAME = "/gui/TurtleImages/GreenTurtle.png";

    private CornerRadii myCornerRadii;
    private Insets myInsets;

    private  Map<Integer, TurtleView> myTurtles;
    //private List<TurtleView> myActiveTurtles;
    private List<Node> lineList = new ArrayList<>();

    protected GraphicsWindow(CornerRadii cornerRadii, Insets insets) {
        myCornerRadii = cornerRadii;
        myInsets = insets;
        myTurtles = new HashMap<>();
        //myActiveTurtles = new ArrayList<>();

        setBackground(new Background(new BackgroundFill(Color.WHITE, myCornerRadii, myInsets)));
        setPrefSize(SIZE.getWidth(), SIZE.getHeight());
        //var primaryTurtle = new TurtleView(getClass().getResource(DEFAULT_FILENAME).toExternalForm());
        addTurtle(1);
    }

    @Override
    public void update(Observable o, Object arg) {
        var state = (Map<String, Double>) arg;
        double x = state.get("xPos");
        double y = state.get("yPos");
        double oldX = state.get("oldXPos");
        double oldY = state.get("oldYPos");
        int id = (int) (state.get("ID")/1);
        setBackground(new Background(new BackgroundFill(getColor(state, "bg"), myCornerRadii, myInsets)));
        if (!myTurtles.containsKey(id)) {
            addTurtle(id);
        }
        TurtleView turtle = myTurtles.get(id);
        turtle.setImage(new Image(this.getClass().getClassLoader().getResourceAsStream(gui.GUI.TURTLE_IMAGES
                + GUI.POSSIBLE_SHAPE_NAMES[(int) (state.get("shapeIndex")/1)] + "Turtle.png")));
        turtle.setActiveStatus(state.get("active") == 1);
        setTurtlePosition(turtle, x, y);
        turtle.setRotate(state.get("Heading"));
        turtle.setVisible(state.get("showing") == 1);
        if ((state.get("ClearScreen") == 1)) {
            clearScreen();
        } else if (state.get("PenDown") == 1 && !(oldX==x && oldY==y)) {
            draw(oldX, oldY, x, y, state.get("penSize"), getColor(state, "pen"));
        }
    }

    private Color getColor(Map<String, Double> state, String objType) {
        int bgColorR = (int) (state.get(objType+"ColorRVal")/1);
        int bgColorG = (int) (state.get(objType+"ColorGVal")/1);
        int bgColorB = (int) (state.get(objType+"ColorBVal")/1);
        return Color.rgb(bgColorR, bgColorG, bgColorB);
    }

    private void clearScreen() {
        getChildren().removeAll(lineList);
        lineList.clear();
        //setTurtlePosition(0, 0);
    }

    private void setTurtlePosition(TurtleView turtle, double x, double y) {
        turtle.setPosition(x + getWidth()/2, y + getHeight()/2);
    }

    private void draw(double oldX, double oldY, double x, double y, double width, Color color) {
//        Line line = new Line(myTurtle.getX(), myTurtle.getY(), x, y);
        Line line = new Line(oldX + getWidth()/2, oldY + getHeight()/2,
                x + getWidth()/2, y + getHeight()/2);
        line.setStrokeWidth(width);
        line.setStroke(color);
        line.setStrokeLineCap(StrokeLineCap.ROUND);
        lineList.add(line);
        getChildren().add(line);
    }

    protected void addTurtle(int id, double x, double y) {
        var turtle = new TurtleView(getClass().getResource(DEFAULT_FILENAME).toExternalForm(), x, y, id);
        myTurtles.put(id, turtle);
        getChildren().add(turtle);
    }

    protected void addTurtle(int id) {
        addTurtle(id, getPrefWidth()/2, getPrefHeight()/2);
    }

    /**
     * Accesses the current turtle that the user controls.
     */
    public Map<Integer, TurtleView> getTurtles() {
        return myTurtles;
    }

    protected void setBackground(Color color) {
        setBackground(new Background(new BackgroundFill(color, myCornerRadii, myInsets)));
    }
}
