package external;

import javafx.collections.ObservableList;
import javafx.geometry.Dimension2D;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class DefinitionList extends ListView implements GUIList {
    /**
     * The DefinitionList displays all of the variables and commands defined by the user. The user can then use
     * one of these variables or commands by typing it into the CommandWindow.
     *
     * @author Tahj Starr
     */

    protected DefinitionList() {
    }

    protected DefinitionList(Point2D location, Dimension2D size) {
        setLayoutX(location.getX());
        setLayoutY(location.getY());
        setPrefSize(size.getWidth(), size.getHeight());
    }

    @Override
    public void save(String name, String value) {
        var nameText = new Text(name);
        nameText.prefHeight(50);
        var valueText = new Text(value);
        getItems().add(new HBox(nameText, valueText));
    }

    @Override
    public String load(String name) {
        return name;
    }

    @Override
    public void setName(String name) {

    }

}