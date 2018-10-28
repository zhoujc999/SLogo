package gui;

import javafx.geometry.Insets;
import javafx.scene.Node;
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

    public static final String GREEN_TURTLE_FILENAME = "/gui/TurtleImages/GreenTurtle.png";

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
        setPrefSize(580, 540);
        //var primaryTurtle = new TurtleView(getClass().getResource(GREEN_TURTLE_FILENAME).toExternalForm());
        addTurtle(0, getPrefWidth()/2, getPrefHeight()/2);

    }

    @Override
    public void update(Observable o, Object arg) {
        var state = (Map<String, Double>) arg;
        double x = state.get("xPos");
        double y = state.get("yPos");
        double oldX = state.get("oldXPos");
        double oldY = state.get("oldYPos");
        double heading = state.get("Heading");
        boolean visible = (state.get("showing") == 1);
        boolean clearScreenFlag = (state.get("ClearScreen") == 1);
        boolean penDown = (state.get("PenDown") == 1);
        int penColorR = (int) (state.get("penColorRVal")/1);
        int penColorG = (int) (state.get("penColorGVal")/1);
        int penColorB = (int) (state.get("penColorBVal")/1);
        Color penColor = Color.rgb(penColorR, penColorG, penColorB);
        double penSize = state.get("penSize");
        int bgColorR = (int) (state.get("bgColorRVal")/1);
        int bgColorG = (int) (state.get("bgColorGVal")/1);
        int bgColorB = (int) (state.get("bgColorBVal")/1);
        Color bgColor = Color.rgb(bgColorR, bgColorG, bgColorB);
        int id = (int) (state.get("ID")/1);

        setBackground(new Background(new BackgroundFill(bgColor, myCornerRadii, myInsets)));
        TurtleView turtle = myTurtles.get(id);
        setTurtlePosition(turtle, x, y);
        turtle.setRotate(heading);
        turtle.setVisible(visible);
        if (clearScreenFlag) {
            clearScreen();
        } else if (penDown && !(oldX==x && oldY==y)) {
            draw(oldX, oldY, x, y, penSize, penColor);
        }
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
        var turtle = new TurtleView(getClass().getResource(GREEN_TURTLE_FILENAME).toExternalForm(), x, y, id);
        getChildren().add(turtle);
        turtle.activate();
    }

    protected void addTurtle(int id) {
        addTurtle(id, getPrefWidth()/2, getPrefHeight()/2);
    }

    /**
     * Accesses the current turtle that the user controls.
     */
    protected Map<Integer, TurtleView> getTurtles() {
        return myTurtles;
    }

    protected void setBackground(Color color) {
        setBackground(new Background(new BackgroundFill(color, myCornerRadii, myInsets)));
    }
}
