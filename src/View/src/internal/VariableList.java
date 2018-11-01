package internal;

import gui.CommandWindow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class VariableList extends DefinitionList {
    /**
     * The VariableList displays all of the variables defined by the user. The user can then use
     * one of these variables by typing it into the CommandWindow.
     *
     * @author Tahj Starr
     * @see DefinitionList
     */

    private static final String LOAD_SIGNAL = "mv";

    public VariableList(Font font, CommandWindow cw, double columnWidth) {
        super(font, cw, columnWidth);
    }

    @Override
    public void save(String name, String value) {
        HBox entry = createEntry(name, value);
        entry.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> load(name));
        getItems().add(entry);
    }

    public void load(String name) {
        getCommandWindow().setInput(LOAD_SIGNAL + " " + name + " ");
    }
}
