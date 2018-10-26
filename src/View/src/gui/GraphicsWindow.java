package gui;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.image.Image;
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
    private static final Map<Double, Color> DOUBLE_TO_COLOR_MAP = Map.ofEntries(
            Map.entry(0.0, Color.BLACK), Map.entry(1.0, Color.BLUE),
            Map.entry(2.0, Color.LIGHTGREEN), Map.entry(3.0, Color.CYAN),
            Map.entry(4.0, Color.RED), Map.entry(5.0, Color.MAGENTA),
            Map.entry(6.0, Color.YELLOW), Map.entry(7.0, Color.WHITE),
            Map.entry(8.0, Color.BROWN), Map.entry(9.0, Color.TAN),
            Map.entry(10.0, Color.GREEN), Map.entry(11.0, Color.AQUA),
            Map.entry(12.0, Color.SALMON), Map.entry(13.0, Color.PURPLE),
            Map.entry(14.0, Color.ORANGE), Map.entry(15.0, Color.GRAY)
    );
    public static final String GREEN_TURTLE_FILENAME = "/gui/TurtleImages/GreenTurtle.png";

    private CornerRadii myCornerRadii;
    private Insets myInsets;

    private List<TurtleView> myActiveTurtles;
    private List<Node> lineList;
    private static final List<TurtleView> TURTLES = List.of();

    protected GraphicsWindow(CornerRadii cornerRadii, Insets insets) {
        myCornerRadii = cornerRadii;
        myInsets = insets;
        myActiveTurtles = new ArrayList<>();

        setBackground(new Background(new BackgroundFill(Color.WHITE, myCornerRadii, myInsets)));
        setPrefSize(580, 540);
        var primaryTurtle = new TurtleView(getClass().getResource(GREEN_TURTLE_FILENAME).toExternalForm());
        activate(primaryTurtle);
        addTurtle(primaryTurtle, getPrefWidth()/2, getPrefHeight()/2);

//        Image turtleImage = new Image(getClass().getResource(GREEN_TURTLE_FILENAME).toExternalForm());
//        //var turtle = new TurtleView(turtleImage, getPrefWidth()/2, getPrefHeight()/2);
//        var turtle = new TurtleView(GREEN_TURTLE_FILENAME, getPrefWidth()/2, getPrefHeight()/2);
//        addTurtle(turtle, 0, 0);
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

        double x = state.get("oldXPos");
        double y = state.get("oldYPos");
        double oldX = state.get("xPos");
        double oldY = state.get("yPos");
        double heading = state.get("heading");
        boolean visible = (state.get("showing") == 1);
        boolean clearScreenFlag = (state.get("clearScreen") == 1);
        boolean penDown = (state.get("penDown") == 1);
        Color penColor = DOUBLE_TO_COLOR_MAP.get(state.get("penColor"));
        double penSize = state.get("penSize");

        for (TurtleView turtle: myActiveTurtles) {
            //setTurtlePosition(turtle, x, y);
            turtle.move(x, y);
            turtle.setRotate(heading);
            turtle.setVisible(visible);

            if (penDown) {
                draw(turtle, x, y, penSize, penColor);
            }
        }

        if (clearScreenFlag) {
            clearScreen();
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

//    private void draw(double oldX, double oldY, double x, double y, double width, Color color) {
//        Line line = new Line(myTurtle.getX(), myTurtle.getY(), x, y);
////        Line line = new Line(oldX, oldY, x, y); //is this preferred?
//        line.setStrokeWidth(width);
//        line.setStroke(color);
//        lineList.add(line);
//        getChildren().add(line);
//    }

    private void draw(TurtleView turtle, double dx, double dy, double width, Color color) {
        Line line = new Line(turtle.getTurtleX(), turtle.getTurtleY(), turtle.getTurtleX() + dx, turtle.getTurtleY() + dy);
//        Line line = new Line(oldX, oldY, x, y); //is this preferred?
        line.setStrokeWidth(width);
        line.setStroke(color);
        System.out.print(color);
        lineList.add(line);
        getChildren().add(line);
    }

    protected void addTurtle(TurtleView turtle, double x, double y) {
        turtle.setPosition(x, y);
        getChildren().add(turtle);
    }

    protected void activate(TurtleView turtle) {
        myActiveTurtles.add(turtle);
    }

    protected void deactivate(TurtleView turtle) {
        myActiveTurtles.remove(turtle);
    }

    /**
     * Accesses the current turtle that the user controls.
     */
    protected List<TurtleView> getTurtles() {
        return Collections.unmodifiableList(myActiveTurtles);
    }

    protected void setBackground(Color color) {
        setBackground(new Background(new BackgroundFill(color, myCornerRadii, myInsets)));
    }
}
