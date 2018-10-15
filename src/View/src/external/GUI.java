package external;

import internal.CommandHistory;
import internal.CommandReference;
import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;

public class GUI extends Region {
    /**
     * The GUI contains and defines the position of all the classes in the View. The language of its text is able to be
     * chosen and changed.
     *
     * @author Tahj Starr
     */

    private static final Point2D COMMAND_WINDOW_LOCATION = new Point2D(50, 500);
    private static final Dimension2D COMMAND_WINDOW_SIZE = new Dimension2D(500, 50);
    private static final Point2D GRAPHICS_WINDOW_LOCATION = new Point2D(50, 50);
    private static final Dimension2D GRAPHICS_WINDOW_SIZE = new Dimension2D(500, 400);
    private static final Point2D RUN_BUTTON_LOCATION = new Point2D(550, 500);
    private static final Dimension2D RUN_BUTTON_SIZE = new Dimension2D(500, 50);


    private CommandWindow myCommandWindow;
    private GraphicsWindow myGraphicsWindow;

    public GUI() {
        setLayoutX(0);
        setLayoutY(0);
        myCommandWindow = new CommandWindow(COMMAND_WINDOW_LOCATION, COMMAND_WINDOW_SIZE);
        myGraphicsWindow = new GraphicsWindow(GRAPHICS_WINDOW_LOCATION, GRAPHICS_WINDOW_SIZE);
        getChildren().addAll(myCommandWindow, myGraphicsWindow, runButton());
    }

    /**
     * Handles what happens when the user presses the 'Run' button.
     */
    void run() {
        myCommandWindow.getInput();
    }

    private Button runButton() {
        var button = new Button("Run");
        button.autosize();
        button.setLayoutX(RUN_BUTTON_LOCATION.getX());
        button.setLayoutY(RUN_BUTTON_LOCATION.getY());
        button.setOnAction(e ->
                run());
        return button;
    }

    /**
     * Access GUI's CommandHistory.
     */
    public CommandHistory getCommandHistory() {
        return null;
    }

    /**
     * Access GUI's CommandReference.
     */
    public CommandReference getCommandReference() {
        return null;
    }

    /**
     * Access GUI's CommandWindow.
     */
    public CommandWindow getCommandWindow() {
        return null;
    }

    /**
     * Access GUI's VariableWindow.
     */
    public VariableWindow getVariableWindow() {
        return null;
    }

    /**
     * Access GUI's GraphicsWindow.
     */
    public GraphicsWindow getGraphicsWindow() {
        return null;
    }

    /**
     * Sets the language of the text in CommandReference.
     */
    void setLanguage(String language) {
    }

}
