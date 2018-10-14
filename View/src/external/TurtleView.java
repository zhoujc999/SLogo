package external;

import java.util.Observable;

public interface TurtleView {
    /**
     * The external.TurtleView is the graphical representation of the turtle. It is able to move and interact with the graphics
     * window. It needs access to various image files to set/change its image.
     *
     * @author Tahj Starr
     */

    /**
     * Updates position of turtle's image.
     */
    void update(Observable turtle, Object args);

}
