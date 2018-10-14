package external;

import internal.CommandHistory;
import internal.CommandReference;

public interface GUI {
    /**
     * The external.GUI contains and defines the position of all the classes in the View. The language of its text is able to be
     * chosen and changed.
     *
     * @author Tahj Starr
     */

    /**
     * Handles what happens when the user presses the 'Run' button.
     */
    void run();

    /**
     * Access external.GUI's internal.CommandHistory.
     */
    CommandHistory getCommandHistory();

    /**
     * Access external.GUI's internal.CommandReference.
     */
    CommandReference getCommandReference();

    /**
     * Access external.GUI's external.CommandWindow.
     */
    CommandWindow getCommandWindow();

    /**
     * Access external.GUI's external.VariableWindow.
     */
    VariableWindow getVariableWindow();

    /**
     * Access external.GUI's external.GraphicsWindow.
     */
    GraphicsWindow getGraphicsWindow();

    /**
     * Sets the language of the text in internal.CommandReference.
     */
    void setLanguage(String language);

}
