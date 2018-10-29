package gui;

import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ResourceBundle;

public abstract class DefinitionList extends ListView implements GUIList {
    /**
     * The DefinitionList displays all of the variables or commands defined by the user. The user can then use
     * one of these variables or commands by typing it into the CommandWindow.
     *
     * @author Tahj Starr
     */

    private Font myFont;
    private CommandWindow myCommandWindow;
    private double myColumnWidth;

    protected DefinitionList(Font font, CommandWindow cw, double columnWidth) {
        myFont = font;
        myCommandWindow = cw;
        myColumnWidth = columnWidth;
    }

    @Override
    public abstract void save(String name, String value);

    protected HBox createEntry(String name, String value) {
        var nameText = new Text(name);
        nameText.setFont(myFont);
        nameText.setWrappingWidth(myColumnWidth);
        var valueText = new Text(value);
        valueText.setFont(myFont);
        return new HBox(nameText, valueText);
    }

    @Override
    public abstract void load(String name);

    protected CommandWindow getCommandWindow() {
        return myCommandWindow;
    }

}