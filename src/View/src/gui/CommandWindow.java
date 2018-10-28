package gui;

import javafx.scene.control.TextArea;
import javafx.scene.text.Font;

public class CommandWindow extends TextArea {
    /**
     * The CommandWindow is the site where the user may type in text in order to execute the desired command. It is able
     * set its text to something that the user may not have typed in. This is useful for loading commands from the
     * CommandHistory.
     *
     * @author Tahj Starr
     */

    protected CommandWindow(Font font, String promptText) {
        setFont(font);
        setPromptText(promptText);
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

}
