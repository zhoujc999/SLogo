package internal;

import gui.CommandWindow;
import gui.GUIList;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class CommandHistory extends ListView implements GUIList {
    /**
     * CommandHistory keeps track of anything that the user runs or tries to run from the CommandWindow and displays it
     * to the user. Users can load a command by clicking on it. The GUI handles saving commands.
     *
     * @author Tahj Starr
     */

    private Font myFont;
    private CommandWindow myCommandWindow;

    public CommandHistory(Font font, CommandWindow cw) {
        myFont = font;
        myCommandWindow = cw;
    }

    @Override
    public void save(String name, String value) {
        var text = new Text(name);
        text.setFont(myFont);

        text.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> load(name));

        getItems().add(text);
    }

    @Override
    public void load(String name) {
        myCommandWindow.setInput(name);
    }

}
