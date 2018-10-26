package main;

import external.ModelPen;
import external.ModelTurtle;
import invoking.Invoker;
import commandFactory.CommandFactory;
import commandFactory.CommandFactoryInterface;
import gui.GUI;
import external.Invokable;
import javafx.application.Application;
import javafx.geometry.Dimension2D;
import javafx.scene.Scene;
import javafx.stage.Stage;
import parsing.Parser;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Main extends Application {

    private static final String TITLE = "SLogo";
    private static final Dimension2D SIZE = new Dimension2D(800, 600);
    private static final String DEFAULT_LANGUAGE = "English";
//    private static final Map<String, Consumer<ModelTurtle>> consumerMap = Map.ofEntries(
//            Map.entry("onFd", (turt) -> turt.forward(5.0),
//                    Map.entry("onTurn",  (turt) -> turt.right(5.0))));

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(TITLE);
        Invokable invoker = new Invoker();
        CommandFactoryInterface myFactory = new CommandFactory(invoker);
        Parser myParser = new Parser(myFactory, DEFAULT_LANGUAGE);
        GUI gui = new GUI(DEFAULT_LANGUAGE, myParser::parseCommand);
        primaryStage.setScene(new Scene(gui, SIZE.getWidth(), SIZE.getHeight()));
        primaryStage.show();
    }


}
