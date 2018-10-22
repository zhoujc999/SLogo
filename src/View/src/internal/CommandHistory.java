package internal;

import gui.GUIList;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

public class CommandHistory extends ListView implements GUIList {
    /**
     * CommandHistory keeps track of anything that the user runs or tries to run from the CommandWindow and displays it
     * to the user. Users can load a command by clicking on it. The GUI handles saving commands.
     *
     * @author Tahj Starr
     */

    @Override
    public void save(String name, String value) {
        getItems().add(new Text(name));
    }

    @Override
    public String load(String name) {
        return name;
    }

    @Override
    public void setName(String name) {

    }

}
