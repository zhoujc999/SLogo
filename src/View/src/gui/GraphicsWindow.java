package gui;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

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
    private TurtleView myTurtle;
    private List<Node> lineList = new ArrayList<>();
    private static final List<TurtleView> TURTLES = List.of();

    protected GraphicsWindow(CornerRadii cornerRadii, Insets insets) {
        myCornerRadii = cornerRadii;
        myInsets = insets;
        setPrefSize(580, 470);
        setBackground(new Background(new BackgroundFill(Color.WHITE, myCornerRadii, myInsets)));
//        Image turtleImage = new Image(this.getClass().getClassLoader().getResourceAsStream(GREEN_TURTLE_FILENAME));
//        var turtle = new TurtleView(turtleImage, getPrefWidth()/2, getPrefHeight()/2);
        var turtle = new TurtleView(getClass().getResource(GREEN_TURTLE_FILENAME).toExternalForm(), getPrefWidth()/2, getPrefHeight()/2);
        addTurtle(turtle);
        myTurtle = turtle;
    }

//    protected GraphicsWindow(Point2D location, Dimension2D size, CornerRadii cornerRadii, Insets insets) {
//        setLayoutX(location.getX());
//        setLayoutY(location.getY());
//        setPrefSize(size.getWidth(), size.getHeight());
//        myCornerRadii = cornerRadii;
//        myInsets = insets;
//        setBackground(new Background(new BackgroundFill(Color.WHITE, myCornerRadii, myInsets)));
//
//        TabPane tabPane = new TabPane();
//        Tab tab = new Tab();
//        tab.setText("new tab");
//        tab.setContent(new Rectangle(200,200, Color.LIGHTSTEELBLUE));
//        Tab tab2 = new Tab();
//        tab2.setText("newer tab");
//        tab2.setContent(new Rectangle(200,200, Color.LIGHTGREEN));
//        tabPane.getTabs().addAll(tab, tab2);
//
//        myTurtle = new TurtleView("TurtleImages/GreenTurtle.png", size.getWidth()/2, size.getHeight()/2);
//        getChildren().addAll(myTurtle, tabPane);
//    }

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

        setBackground(new Background(new BackgroundFill(bgColor, myCornerRadii, myInsets)));
        setTurtlePosition(x, y);
        myTurtle.setRotate(heading);
        myTurtle.setVisible(visible);
        if (clearScreenFlag) {
            clearScreen();
        }
        else if (penDown) {
            draw(oldX, oldY, x, y, penSize, penColor);
        }
    }

    private void clearScreen() {
        getChildren().removeAll(lineList);
        lineList.clear();
        setTurtlePosition(0, 0);
    }

    private void setTurtlePosition(double x, double y) {
        myTurtle.setPosition(x + getWidth()/2, y + getHeight()/2);
    }

    private void draw(double oldX, double oldY, double x, double y, double width, Color color) {
//        Line line = new Line(myTurtle.getX(), myTurtle.getY(), x, y);
        Line line = new Line(oldX + getWidth()/2, oldY + getHeight()/2,
                x + getWidth()/2, y + getHeight()/2);
        line.setStrokeWidth(width);
        line.setStroke(color);
        System.out.print(color);
        lineList.add(line);
        getChildren().add(line);
    }

    protected void addTurtle(TurtleView turtle) {
        getChildren().add(turtle);
    }

    /**
     * Accesses the current turtle that the user controls.
     */
    TurtleView getTurtle() {
        return myTurtle;
    }

    protected void setBackground(Color color) {
        setBackground(new Background(new BackgroundFill(color, myCornerRadii, myInsets)));
    }
}
