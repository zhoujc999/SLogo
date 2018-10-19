package external;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;

import java.util.Observable;
import java.util.Observer;

public class TurtleView extends ImageView {
    /**
     * The TurtleView is the graphical representation of the turtle. It is able to move and interact with the graphics
     * window. It needs access to various image files to set/change its image.
     *
     * @author Tahj Starr
     */

    private static final double SIZE = 50;

    protected TurtleView(String url, double x, double y) {
        super(url);
        setFitWidth(SIZE);
        setFitHeight(SIZE);
        setPosition(x, y);
    }

    protected void setPosition(double x, double y) {
        relocate(x - SIZE/2, y - SIZE/2);
    }

    /**
     * Updates position of turtle's image.
     */
    public void update() {
//        setPosition();
//        setRotate();
//        setVisible();
    }

}
