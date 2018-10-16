package external;

import javafx.geometry.Dimension2D;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

    private TurtleView myTurtle;

    protected GraphicsWindow(Point2D location, Dimension2D size) {
        setLayoutX(location.getX());
        setLayoutY(location.getY());
        setPrefSize(size.getWidth(), size.getHeight());
        setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(0), new Insets(0))));

        myTurtle = new TurtleView("GreenTurtle.PNG", size.getWidth()/2, size.getHeight()/2);
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

        myTurtle.setPosition(x, y);
        myTurtle.setRotate(heading);
        myTurtle.setVisible(visible);
        if (penDown) {
            draw(x, y);
        }
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
}
