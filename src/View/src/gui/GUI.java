package gui;

import internal.ButtonPanel;
import internal.CommandHistory;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

import java.util.Map;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class GUI extends SplitPane {
    /**
     * The GUI contains and defines the position of all the classes in the View. The language of its text is able to be
     * chosen and changed.
     *
     * @author Tahj Starr
     */

    private static final Dimension2D COMMAND_WINDOW_SIZE = new Dimension2D(520, 60);
    private static final Point2D RUN_BUTTON_LOCATION = new Point2D(10, 530);
    private static final Dimension2D RUN_BUTTON_SIZE = new Dimension2D(50, 25);
    private static final Point2D CLEAR_BUTTON_LOCATION = new Point2D(10, 565);
    private static final Dimension2D CLEAR_BUTTON_SIZE = new Dimension2D(50, 25);
    public static final Point2D BUTTON_PANEL_LOCATION = new Point2D(600, 50);
    public static final Dimension2D BUTTON_PANEL_SIZE = new Dimension2D(190, 200);

    private static final double HORIZONTAL_DIVIDER_POSITION = 0.9;
    private static final double VERTICAL_DIVIDER_POSITION = 0.75;

    public static final double SPACING = 10;
    private static final double DEFINITION_LIST_COLUMN_WIDTH = 100;
    public static final String DEFAULT_RESOURCES = "/gui/GUIProperties/GUI";
    public static final String TURTLE_IMAGES = "/gui/TurtleImages/";
    public static final List<String> RECOGNIZED_LANGUAGES = List.of(
            "English",
            "Spanish"
    );
    
    private final Consumer<String> myParsingFunc;
    private final ButtonPanel buttonPanel;
    Supplier<int[][]> penPaletteSupplier;
    Supplier<int[][]> backgroundPaletteSupplier;
    private String myLanguage;
    private ResourceBundle myResources;
    private static final Font CODE_FONT = new Font("Courier New", 10);

    private CommandWindow myCommandWindow;
    private GraphicsWindow myGraphicsWindow;
    private TabPane myProjectWindow;
    private DefinitionList myVariables;
    private DefinitionList myCommands;
    private CommandHistory myCommandHistory;

    public GUI(String language, Consumer<String> parsingFunc, Map<String, Supplier> supplierMap) {
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCES + language);
        myLanguage = language;
        myParsingFunc = parsingFunc;
        buttonPanel = new ButtonPanel(language, myResources, parsingFunc, supplierMap);

        initializeComponents(language);
        initializeLayout();
    }

    private void initializeComponents(String language) {
        myCommandWindow = new CommandWindow(CODE_FONT, myResources.getString("PromptText"));
        myCommandWindow.setPrefWidth(COMMAND_WINDOW_SIZE.getWidth());
        myGraphicsWindow = new GraphicsWindow(new CornerRadii(0), new Insets(0));
        myVariables = new DefinitionList(CODE_FONT, DEFINITION_LIST_COLUMN_WIDTH);
        myVariables.save("length", "5");
        myCommands = new DefinitionList(CODE_FONT, DEFINITION_LIST_COLUMN_WIDTH);
        myCommands.save("length", "5");
        myCommandHistory = new CommandHistory(CODE_FONT, myCommandWindow);
        myProjectWindow = new TabPane(new Tab(myResources.getString("VariableTab"), myVariables), new Tab(myResources.getString("CommandTab"), myCommands), new Tab(myResources.getString("HistoryTab"), myCommandHistory));
        myProjectWindow.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
    }

    private void initializeLayout() {
        var commandControl = new VBox(runButton(), clearButton());
        commandControl.setSpacing(SPACING);
        commandControl.setAlignment(Pos.CENTER);
        var commandPanel = new HBox(commandControl, myCommandWindow);
        commandPanel.setSpacing(SPACING);
        var sidePanel = new VBox(buttonPanel, myProjectWindow);
        var mainPanel = new SplitPane(myGraphicsWindow, commandPanel);

        mainPanel.setDividerPosition(0, HORIZONTAL_DIVIDER_POSITION);
        mainPanel.setOrientation(Orientation.VERTICAL);
        setDividerPosition(0, VERTICAL_DIVIDER_POSITION);
        getItems().addAll(mainPanel, sidePanel);
    }

    /**
     * Handles what happens when the user presses the 'Run' button.
     */
    void run() {
//        try {
//            String input = myCommandWindow.getInput();
//            myCommandHistory.save(input, "");
//            myParsingFunc.accept(input);
//        } catch (Exception e) {
//            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
//        }
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

    /**
     * Access GUI's CommandHistory.
     */
    public CommandHistory getCommandHistory() {
        return myCommandHistory;
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
   public void setLanguage(String language) {
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCES + language);
        myLanguage = language;
        getItems().clear();
        initializeComponents(language);
        initializeLayout();
    }
}
