package gui;

import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class DefinitionList extends ListView implements GUIList {
    /**
     * The DefinitionList displays all of the variables and commands defined by the user. The user can then use
     * one of these variables or commands by typing it into the CommandWindow.
     *
     * @author Tahj Starr
     */

    private Font myFont;
    private double myColumnWidth;

    protected DefinitionList(Font font, double columnWidth) {
        myFont = font;
        myColumnWidth = columnWidth;
    }

    protected DefinitionList(Point2D location, Dimension2D size) {
        setLayoutX(location.getX());
        setLayoutY(location.getY());
        setPrefSize(size.getWidth(), size.getHeight());
    }

    @Override
    public void save(String name, String value) {
        var nameText = new Text(name);
        nameText.setFont(myFont);
        nameText.setWrappingWidth(myColumnWidth);
        var valueText = new Text(value);
        valueText.setFont(myFont);
        var entry = new HBox(nameText, valueText);
        getItems().add(entry);
    }

    @Override
    public String load(String name) {
        return name;
    }

    @Override
    public void setName(String name) {

    }

}