package external;

import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class ProjectWindow extends TabPane {

    protected ProjectWindow(Point2D location, Dimension2D size, Tab... tabs) {
        super(tabs);
        setLayoutX(location.getX());
        setLayoutY(location.getY());
        setPrefSize(size.getWidth(), size.getHeight());
    }

}
