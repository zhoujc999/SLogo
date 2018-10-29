package main;

import external.StdModelTurtle;
import invoking.Invoker;
import commandFactory.CommandFactory;
import commandFactory.CommandFactoryInterface;
import gui.GUI;
import external.Invokable;
import javafx.application.Application;
import javafx.geometry.Dimension2D;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import parsing.Parser;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main extends Application {

    private static final String TITLE = "SLogo";
    private static final Dimension2D SIZE = new Dimension2D(800, 600);
    private static final String DEFAULT_LANGUAGE = "English";

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(TITLE);
        Invokable invoker = new Invoker();
        Parser myParser = new Parser(invoker, DEFAULT_LANGUAGE);
        ( (Invoker) invoker ).setMyParse(myParser);
        Map<String, Supplier> supplierMap = Map.of("penPalette", ( (Invoker) invoker )::getPenPalette,
                "backgroundPalette", ( (Invoker) invoker )::getBackgroundPalette);
        Map<String, Consumer<String>> stringConsumerMap = Map.of("parsingFunc", myParser::parseCommand,
                "modelLangFunc", lang -> myParser.getLanguageInterface().changeLanguage(lang));
        GUI gui = new GUI(DEFAULT_LANGUAGE, stringConsumerMap, supplierMap);
        Consumer<StdModelTurtle> turtleObserverConsumer = turt -> turt.addObserver(gui.getGraphicsWindow());
        ( (Invoker) invoker ).setAddTurtleObserver(turtleObserverConsumer);
        Scene scene = new Scene(gui, SIZE.getWidth(), SIZE.getHeight());
        scene.setOnKeyPressed(event -> handleKeyInput(event.getCode(), myParser::parseCommand));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleKeyInput(KeyCode code, Consumer<String> parsingFunc) {
        if (code == KeyCode.W) {
            parsingFunc.accept("fd 5");
        } else if (code == KeyCode.S) {
            parsingFunc.accept("bk 5");
        } else if (code == KeyCode.A) {
            parsingFunc.accept("rt 5");
        } else if (code == KeyCode.D) {
            parsingFunc.accept("lt 5");
        }
    }


}
