package external;

import internal.CommandHistory;
import internal.CommandReference;
import javafx.geometry.Dimension2D;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Point2D;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class GUI extends SplitPane {
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
    private static final Point2D PROJECT_WINDOW_LOCATION = new Point2D(600, 210);
    private static final Dimension2D PROJECT_WINDOW_SIZE = new Dimension2D(190, 380);

    private CommandWindow myCommandWindow;
    private GraphicsWindow myGraphicsWindow;
    private TabPane myProjectWindow;
    private DefinitionList myVariables;
    private DefinitionList myCommands;
    private CommandHistory myCommandHistory;
    private CommandReference myCommandReference;

//    public GUI() {
//        setLayoutX(0);
//        setLayoutY(0);
//        myCommandWindow = new CommandWindow(COMMAND_WINDOW_LOCATION, COMMAND_WINDOW_SIZE);
//        myGraphicsWindow = new GraphicsWindow(GRAPHICS_WINDOW_LOCATION, GRAPHICS_WINDOW_SIZE, new CornerRadii(0), new Insets(0));
//        myVariables = new DefinitionList(PROJECT_WINDOW_LOCATION, PROJECT_WINDOW_SIZE);
//        myVariables.saveVariable("length", "5");
//        myProjectWindow = new TabPane(new Tab("Variables", new Rectangle(10, 10)), new Tab("Commands", new Rectangle(10, 10)));
//        myProjectWindow.setLayoutX(PROJECT_WINDOW_LOCATION.getX());
//        myProjectWindow.setLayoutY(PROJECT_WINDOW_LOCATION.getY());
//        myCommandReference = new CommandReference();
//        getChildren().addAll(myCommandWindow, myGraphicsWindow, myProjectWindow, runButton(), clearButton(), buttonPanel());
//    }

    public GUI() {
        myCommandWindow = new CommandWindow();
        myGraphicsWindow = new GraphicsWindow(new CornerRadii(0), new Insets(0));
        myCommandReference = new CommandReference();
        myVariables = new DefinitionList();
        myVariables.save("length", "5");
        myCommands = new DefinitionList();
        myCommands.save("length", "5");
        myCommandHistory = new CommandHistory();
        myProjectWindow = new TabPane(new Tab("Variables", myVariables), new Tab("Commands", myCommands), new Tab("Command History", myCommandHistory));
        var commandControl = new VBox(runButton(), clearButton());
        var commandPanel = new HBox(commandControl, myCommandWindow);
        var sidePanel = new VBox(buttonPanel(), myProjectWindow);
        var mainPanel = new SplitPane(myGraphicsWindow, commandPanel);
        mainPanel.setDividerPosition(0, 0.75);
        mainPanel.setOrientation(Orientation.VERTICAL);
        setDividerPosition(0, 0.75);
        getItems().addAll(mainPanel, sidePanel);
//        System.out.println(myGraphicsWindow.widthProperty());
    }

    /**
     * Handles what happens when the user presses the 'Run' button.
     */
    void run() {
        myCommandHistory.save(myCommandWindow.getInput(), "");
    }

    private Button runButton() {
        var button = new Button("Run");
        button.setLayoutX(RUN_BUTTON_LOCATION.getX());
        button.setLayoutY(RUN_BUTTON_LOCATION.getY());
        button.setPrefSize(RUN_BUTTON_SIZE.getWidth(), RUN_BUTTON_SIZE.getHeight());
        button.setOnAction(e -> run());
        return button;
    }

    private Button clearButton() {
        var button = new Button("Clear");
        button.setLayoutX(CLEAR_BUTTON_LOCATION.getX());
        button.setLayoutY(CLEAR_BUTTON_LOCATION.getY());
        button.setPrefSize(CLEAR_BUTTON_SIZE.getWidth(), CLEAR_BUTTON_SIZE.getHeight());
        button.setOnAction(e -> myCommandWindow.clear());
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
                new Text("Language"),
                referenceButton());

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

    private Button referenceButton() {
        var button = new Button("Reference");
        button.setOnAction(e -> myCommandReference.show());
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
     * Access GUI's DefinitionList.
     */
    public DefinitionList getVariableWindow() {
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
