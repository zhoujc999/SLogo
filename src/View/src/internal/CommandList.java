package internal;

import gui.CommandWindow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class CommandList extends DefinitionList {
    /**
     * The DefinitionList displays all of the variables defined by the user. The user can then use
     * one of these variables or commands by typing it into the CommandWindow.
     *
     * @author Tahj Starr
     */

    public CommandList(Font font, CommandWindow cw, double columnWidth) {
        super(font, cw, columnWidth);
    }

    @Override
    public void save(String name, String value) {
        HBox entry = createEntry(name, value);
        entry.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> load(value));
        getItems().add(entry);
    }

    public void load(String name) {
        getCommandWindow().setInput(name);
    }
}
