package external;

import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.scene.control.TextArea;

public class CommandWindow extends TextArea {
    /**
     * The CommandWindow is the site where the user may type in text in order to execute the desired command. It is able
     * set its text to something that the user may not have typed in. This is useful for loading commands from the
     * CommandHistory.
     *
     * @author Tahj Starr
     */

    protected CommandWindow(Point2D location, Dimension2D size) {
        setLayoutX(location.getX());
        setLayoutY(location.getY());
        setPrefSize(size.getWidth(), size.getHeight());
    }

    /**
     * Returns text input from user.
     */
    public String getInput() {
        String text = getText();
        clear();
        return text;
    }

    /**
     * Sets the text input to the specified value.
     */
    public void setInput(String command) {
        setText(command);
    }

    /**
     * Sets the name displayed by CommandWindow based on the language to which GUI is set.
     */
    public void setName(String name) {

    }

}
