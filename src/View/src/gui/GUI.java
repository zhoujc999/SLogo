package gui;

import internal.CommandHistory;
import internal.CommandReference;
import javafx.geometry.*;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Consumer;

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

    private static final double SPACING = 10;
    private static final double DEFINITION_LIST_COLUMN_WIDTH = 100;
    private static final String DEFAULT_TURTLE = "GreenTurtle.png";
    private static final String DEFAULT_RESOURCES = "/gui/GUIProperties/GUI";
    private static final String TURTLE_IMAGES = "/gui/TurtleImages/";
    private static final List<String> RECOGNIZED_LANGUAGES = List.of(
            "English",
            "Spanish"
    );

    private String myLanguage;
    private ResourceBundle myResources;
    private final Consumer<String> myParsingFunc;
    private static final Font CODE_FONT = new Font("Courier New", 10);

    private CommandWindow myCommandWindow;
    private GraphicsWindow myGraphicsWindow;
    private TabPane myProjectWindow;
    private DefinitionList myVariables;
    private DefinitionList myCommands;
    private CommandHistory myCommandHistory;
    private CommandReference myCommandReference;

    public GUI(String language, Consumer<String> parsingFunc) {
        myLanguage = language;
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCES + language);
        myParsingFunc = parsingFunc;

        initializeComponents(language);
        initializeLayout();
    }

    private void initializeComponents(String language) {
        myCommandWindow = new CommandWindow(CODE_FONT, myResources.getString("PromptText"));
        myCommandWindow.setPrefWidth(COMMAND_WINDOW_SIZE.getWidth());
        myGraphicsWindow = new GraphicsWindow(new CornerRadii(0), new Insets(0));
        myCommandReference = new CommandReference(language);
        myVariables = new DefinitionList(CODE_FONT, DEFINITION_LIST_COLUMN_WIDTH);
        myVariables.save("length", "5");
        myCommands = new DefinitionList(CODE_FONT, DEFINITION_LIST_COLUMN_WIDTH);
        myCommands.save("length", "5");
        myCommandHistory = new CommandHistory(CODE_FONT);
        myProjectWindow = new TabPane(new Tab(myResources.getString("VariableTab"), myVariables), new Tab(myResources.getString("CommandTab"), myCommands), new Tab(myResources.getString("HistoryTab"), myCommandHistory));
        myProjectWindow.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
    }

    private void initializeLayout() {
        var commandControl = new VBox(runButton(), clearButton());
        commandControl.setSpacing(SPACING);
        commandControl.setAlignment(Pos.CENTER);
        var commandPanel = new HBox(commandControl, myCommandWindow);
        commandPanel.setSpacing(SPACING);
        var sidePanel = new VBox(buttonPanel(), myProjectWindow);
        var mainPanel = new SplitPane(myGraphicsWindow, commandPanel);

        mainPanel.setDividerPosition(0, 0.9);
        mainPanel.setOrientation(Orientation.VERTICAL);
        setDividerPosition(0, 0.75);
        getItems().addAll(mainPanel, sidePanel);
    }

    /**
     * Handles what happens when the user presses the 'Run' button.
     */
    void run() {
        String input = myCommandWindow.getInput();
        myCommandHistory.save(input, "");
        myParsingFunc.accept(input);
    }

    private Button runButton() {
        var button = new Button(myResources.getString("RunButton"));
        button.setLayoutX(RUN_BUTTON_LOCATION.getX());
        button.setLayoutY(RUN_BUTTON_LOCATION.getY());
        button.setPrefSize(RUN_BUTTON_SIZE.getWidth(), RUN_BUTTON_SIZE.getHeight());
        button.setOnAction(e -> run());
        return button;
    }

    private Button clearButton() {
        var button = new Button(myResources.getString("ClearButton"));
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
        buttonPanel.setHgap(SPACING);
        buttonPanel.setVgap(SPACING);
        buttonPanel.setPadding(new Insets(SPACING));

        buttonPanel.addColumn(0,
                new Text(myResources.getString("BackgroundPicker")),
                new Text(myResources.getString("TurtlePicker")),
                new Text(myResources.getString("PenPicker")),
                new Text(myResources.getString("LanguagePicker")));

        buttonPanel.addColumn(1,
                backgroundPicker(),
                turtlePicker(),
                penPicker(),
                languagePicker());

        buttonPanel.add(referenceButton(), 0, 4, 2, 1);
        for (Node node: buttonPanel.getChildren()) {
            buttonPanel.setHalignment(node, HPos.CENTER);
        }

        return buttonPanel;
    }

    private ColorPicker backgroundPicker() {
        var picker = new ColorPicker(Color.WHITE);
        picker.setStyle("-fx-color-label-visible: false");
        picker.setOnAction(e -> myGraphicsWindow.setBackground(picker.getValue()));
        return picker;
    }

    private ComboBox turtlePicker() {
        var picker = new ComboBox<String>();
        var resource = ResourceBundle.getBundle(DEFAULT_RESOURCES + "Turtles" + myLanguage);

        var images = resource.getKeys();
        while (images.hasMoreElements()) {
            picker.getItems().add(images.nextElement());
        }

        picker.setOnAction(e -> {
            String filename = TURTLE_IMAGES + resource.getString(picker.getValue()) + ".png";
            transformTurtles(new ImageView(getClass().getResource(filename).toExternalForm()));
        });
        return picker;
    }

    private void transformTurtles(ImageView img) {
        for (TurtleView turtle: myGraphicsWindow.getTurtles()) {
            turtle.setImage(img.getImage());
        }
    }

    private ColorPicker penPicker() {
        var picker = new ColorPicker(Color.BLACK);
        picker.setStyle("-fx-color-label-visible: false ;");
        picker.setOnAction(e -> setTurtlePens(picker.getValue()));
        return picker;
    }

    private void setTurtlePens(Color color) {
        for (TurtleView turtle: myGraphicsWindow.getTurtles()) {
            turtle.setPenColor(color);
        }
    }

    private ComboBox languagePicker() {
        var picker = new ComboBox<String>();
        picker.getItems().addAll(RECOGNIZED_LANGUAGES);
        picker.setOnAction(e -> setLanguage(picker.getValue()));
        return picker;
    }

    private Button referenceButton() {
        var button = new Button(myResources.getString("ReferenceButton"));
        button.setOnAction(e -> myCommandReference.show());
        return button;
    }

    /**
     * Access GUI's CommandHistory.
     */
    public CommandHistory getCommandHistory() {
        return myCommandHistory;
    }

    /**
     * Access GUI's CommandReference.
     */
    public CommandReference getCommandReference() {
        return myCommandReference;
    }

    /**
     * Access GUI's CommandWindow.
     */
    public CommandWindow getCommandWindow() {
        return myCommandWindow;
    }

    /**
     * Access GUI's DefinitionList.
     */
    public DefinitionList getVariableWindow() {
        return myVariables;
    }

    /**
     * Access GUI's GraphicsWindow.
     */
    public GraphicsWindow getGraphicsWindow() {
        return myGraphicsWindow;
    }

    /**
     * Sets the language of the text in CommandReference.
     */
    void setLanguage(String language) {
        myCommandReference.setLanguage(language);
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCES + language);
        myLanguage = language;
        getItems().clear();
        initializeComponents(language);
        initializeLayout();
    }

}
