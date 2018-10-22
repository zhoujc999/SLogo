package main;

import Invoking.Invoker;
import commandFactory.CommandFactory;
import commandFactory.CommandFactoryInterface;
import gui.GUI;
import external.Invokable;
import javafx.application.Application;
import javafx.geometry.Dimension2D;
import javafx.scene.Scene;
import javafx.stage.Stage;
import parsing.Parser;

public class Main extends Application {

    private static final String TITLE = "SLogo";
    private static final Dimension2D SIZE = new Dimension2D(800, 600);
    private static final String DEFAULT_LANGUAGE = "English";

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(TITLE);
        Invokable invoker = new Invoker();
        CommandFactoryInterface myFactory = new CommandFactory(invoker);
        Parser myParser = new Parser(myFactory, DEFAULT_LANGUAGE);
        GUI gui = new GUI(DEFAULT_LANGUAGE, myParser::parseCommand);
        gui.getCommandWindow().getInput();
        primaryStage.setScene(new Scene(gui, SIZE.getWidth(), SIZE.getHeight()));
        primaryStage.show();
    }
}
