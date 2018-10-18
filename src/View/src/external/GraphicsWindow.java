package external;

import javafx.geometry.Dimension2D;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.List;
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

    protected GraphicsWindow(Point2D location, Dimension2D size, CornerRadii cornerRadii, Insets insets) {
        setLayoutX(location.getX());
        setLayoutY(location.getY());
        setPrefSize(size.getWidth(), size.getHeight());
        myCornerRadii = cornerRadii;
        myInsets = insets;
        setBackground(new Background(new BackgroundFill(Color.WHITE, myCornerRadii, myInsets)));

        myTurtle = new TurtleView("GreenTurtle.png", size.getWidth()/2, size.getHeight()/2);
        getChildren().add(myTurtle);
    }

    @Override
    public void update(Observable o, Object arg) {
        var state = (List<Double>) arg;

        double x = state.get(0);
        double y = state.get(1);
        double heading = state.get(2);
        boolean visible = Boolean.parseBoolean(state.get(3).toString());
        boolean penDown = Boolean.parseBoolean(state.get(3).toString());

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
