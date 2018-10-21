package external;

import javafx.geometry.Dimension2D;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class GraphicsWindow extends Pane implements Observer {
    /**
     * GraphicsWindow contains the turtle. The turtles may in a list if multiple turtles want to be added.
     *
     * @author Tahj Starr
     */

    private CornerRadii myCornerRadii;
    private Insets myInsets;
    private TurtleView myTurtle;
    private static final List<TurtleView> TURTLES = List.of();

    protected GraphicsWindow(CornerRadii cornerRadii, Insets insets) {
        myCornerRadii = cornerRadii;
        myInsets = insets;
        setPrefSize(580, 470);
        setBackground(new Background(new BackgroundFill(Color.WHITE, myCornerRadii, myInsets)));
        var turtle = new TurtleView("TurtleImages/GreenTurtle.png", getPrefWidth()/2, getPrefHeight()/2);
        addTurtle(turtle);
        myTurtle = turtle;
    }

    protected GraphicsWindow(Point2D location, Dimension2D size, CornerRadii cornerRadii, Insets insets) {
        setLayoutX(location.getX());
        setLayoutY(location.getY());
        setPrefSize(size.getWidth(), size.getHeight());
        myCornerRadii = cornerRadii;
        myInsets = insets;
        setBackground(new Background(new BackgroundFill(Color.WHITE, myCornerRadii, myInsets)));

        TabPane tabPane = new TabPane();
        Tab tab = new Tab();
        tab.setText("new tab");
        tab.setContent(new Rectangle(200,200, Color.LIGHTSTEELBLUE));
        Tab tab2 = new Tab();
        tab2.setText("newer tab");
        tab2.setContent(new Rectangle(200,200, Color.LIGHTGREEN));
        tabPane.getTabs().addAll(tab, tab2);

        myTurtle = new TurtleView("TurtleImages/GreenTurtle.png", size.getWidth()/2, size.getHeight()/2);
        getChildren().addAll(myTurtle, tabPane);
    }

    @Override
    public void update(Observable o, Object arg) {
        var state = (Map<String, Double>) arg;

        double x = state.get("xPos");
        double y = state.get("yPos");
        double heading = state.get("heading");
        boolean visible = Boolean.parseBoolean(state.get("showing").toString());
        boolean penDown = Boolean.parseBoolean(state.get("penDown").toString());

        setTurtlePosition(x, y);
        myTurtle.setRotate(heading);
        myTurtle.setVisible(visible);
        if (penDown) {
            draw(x, y);
        }
    }

    private void setTurtlePosition(double x, double y) {
        myTurtle.setPosition(x + getWidth()/2, y + getHeight()/2);
    }

    private void draw(double x, double y) {
        getChildren().add(new Line(myTurtle.getX(), myTurtle.getY(), x, y));
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
