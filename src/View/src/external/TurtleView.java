package external;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

import java.util.Observable;

public class TurtleView {
    /**
     * The TurtleView is the graphical representation of the turtle. It is able to move and interact with the graphics
     * window. It needs access to various image files to set/change its image.
     *
     * @author Tahj Starr
     */

    private static final double SIZE = 50;

    private ImageView mySprite;

    protected TurtleView(ImageView sprite, double x, double y) {
        mySprite = sprite;
        mySprite.setFitWidth(SIZE);
        mySprite.setFitHeight(SIZE);
        mySprite.setX(x - SIZE/2);
        mySprite.setY(y - SIZE/2);
    }

    /**
     * Updates position of turtle's image.
     */
    void update(Observable turtle, Object args) {
    }

    protected ImageView getSprite() {
        return mySprite;
    }

}
