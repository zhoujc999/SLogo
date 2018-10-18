package external;

import internal.CommandHistory;
import internal.CommandReference;
import javafx.geometry.Dimension2D;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

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
    private static final Point2D BUTTON_PANEL_LOCATION = new Point2D(600, 50);
    private static final Dimension2D BUTTON_PANEL_SIZE = new Dimension2D(190, 200);



    private CommandWindow myCommandWindow;
    private GraphicsWindow myGraphicsWindow;

    public GUI() {
        setLayoutX(0);
        setLayoutY(0);
        myCommandWindow = new CommandWindow(COMMAND_WINDOW_LOCATION, COMMAND_WINDOW_SIZE);
        myGraphicsWindow = new GraphicsWindow(GRAPHICS_WINDOW_LOCATION, GRAPHICS_WINDOW_SIZE, new CornerRadii(0), new Insets(0));
        getChildren().addAll(myCommandWindow, myGraphicsWindow, runButton(), clearButton(), buttonPanel());
    }

    /**
     * Handles what happens when the user presses the 'Run' button.
     */
    void run() {
        myCommandWindow.getInput();
    }

    private Button runButton() {
        var button = new Button("Run");
        button.setLayoutX(RUN_BUTTON_LOCATION.getX());
        button.setLayoutY(RUN_BUTTON_LOCATION.getY());
        button.setPrefSize(RUN_BUTTON_SIZE.getWidth(), RUN_BUTTON_SIZE.getHeight());
        button.setOnAction(e ->
                run());
        return button;
    }

    private Button clearButton() {
        var button = new Button("Clear");
        button.setLayoutX(CLEAR_BUTTON_LOCATION.getX());
        button.setLayoutY(CLEAR_BUTTON_LOCATION.getY());
        button.setPrefSize(CLEAR_BUTTON_SIZE.getWidth(), CLEAR_BUTTON_SIZE.getHeight());
        button.setOnAction(e ->
                myCommandWindow.clear());
        return button;
    }

    private GridPane buttonPanel() {
        var buttonPanel = new GridPane();
        buttonPanel.setLayoutX(BUTTON_PANEL_LOCATION.getX());
        buttonPanel.setLayoutY(BUTTON_PANEL_LOCATION.getY());
        buttonPanel.setPrefSize(BUTTON_PANEL_SIZE.getWidth(), BUTTON_PANEL_SIZE.getHeight());
        buttonPanel.addColumn(0,
                new Text("Background Color"),
                new Text("Turtle Image"),
                new Text("Pen Color"),
                new Text("Language"));
        buttonPanel.addColumn(1,
                backgroundPicker(),
                turtlePicker(),
                penPicker(),
                languagePicker());
        return buttonPanel;
    }

    private ColorPicker backgroundPicker() {
        var picker = new ColorPicker(Color.WHITE);
        picker.setStyle("-fx-color-label-visible: false");
        picker.setOnAction(e -> myGraphicsWindow.setBackground(picker.getValue()));
        return picker;
    }

    private ComboBox turtlePicker() {
        var picker = new ComboBox<Image>();
        picker.getItems().addAll(
                new Image("GreenTurtle.png"),
                new Image("RedTurtle.png"),
                new Image("BlueTurtle.png")
        );
        picker.setOnAction(e -> myGraphicsWindow.getTurtle().setImage(picker.getValue()));
        return picker;
    }

    private ColorPicker penPicker() {
        var picker = new ColorPicker(Color.BLACK);
        picker.setStyle("-fx-color-label-visible: false ;");
        picker.setOnAction(e -> myGraphicsWindow.getTurtle().setPenColor(picker.getValue()));
        return picker;
    }

    private ComboBox languagePicker() {
        var picker = new ComboBox<String>();
        picker.getItems().add("English");
        //picker.setStyle("-fx-color-label-visible: false ;");
        return picker;
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
