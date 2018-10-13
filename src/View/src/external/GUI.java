package external;

import internal.CommandHistory;
import internal.CommandReference;

public interface GUI {
    /**
     * The GUI contains and defines the position of all the classes in the View. The language of its text is able to be
     * chosen and changed.
     *
     * @author Tahj Starr
     */

    /**
     * Handles what happens when the user presses the 'Run' button.
     */
    void run();

    /**
     * Access GUI's CommandHistory.
     */
    CommandHistory getCommandHistory();

    /**
     * Access GUI's CommandReference.
     */
    CommandReference getCommandReference();

    /**
     * Access GUI's CommandWindow.
     */
    CommandWindow getCommandWindow();

    /**
     * Access GUI's VariableWindow.
     */
    VariableWindow getVariableWindow();

    /**
     * Access GUI's GraphicsWindow.
     */
    GraphicsWindow getGraphicsWindow();

    /**
     * Sets the language of the text in CommandReference.
     */
    void setLanguage(String language);

}
