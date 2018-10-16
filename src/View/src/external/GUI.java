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

    private static final Point2D COMMAND_WINDOW_LOCATION = new Point2D(70, 530);
    private static final Dimension2D COMMAND_WINDOW_SIZE = new Dimension2D(520, 60);
    private static final Point2D GRAPHICS_WINDOW_LOCATION = new Point2D(10, 50);
    private static final Dimension2D GRAPHICS_WINDOW_SIZE = new Dimension2D(580, 470);
    private static final Point2D RUN_BUTTON_LOCATION = new Point2D(10, 530);
    private static final Dimension2D RUN_BUTTON_SIZE = new Dimension2D(50, 25);
    private static final Point2D CLEAR_BUTTON_LOCATION = new Point2D(10, 565);
    private static final Dimension2D CLEAR_BUTTON_SIZE = new Dimension2D(50, 25);


    private CommandWindow myCommandWindow;
    private GraphicsWindow myGraphicsWindow;

    public GUI() {
        setLayoutX(0);
        setLayoutY(0);
        myCommandWindow = new CommandWindow(COMMAND_WINDOW_LOCATION, COMMAND_WINDOW_SIZE);
        myGraphicsWindow = new GraphicsWindow(GRAPHICS_WINDOW_LOCATION, GRAPHICS_WINDOW_SIZE);
        getChildren().addAll(myCommandWindow, myGraphicsWindow, runButton(), clearButton());
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
        button.setPrefSize(RUN_BUTTON_SIZE.getWidth(), RUN_BUTTON_SIZE.getHeight());
        button.setOnAction(e ->
                run());
        return button;
    }

    private Button clearButton() {
        var button = new Button("Clear");
        button.autosize();
        button.setLayoutX(CLEAR_BUTTON_LOCATION.getX());
        button.setLayoutY(CLEAR_BUTTON_LOCATION.getY());
        button.setPrefSize(CLEAR_BUTTON_SIZE.getWidth(), CLEAR_BUTTON_SIZE.getHeight());
        button.setOnAction(e ->
                myCommandWindow.clear());
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
