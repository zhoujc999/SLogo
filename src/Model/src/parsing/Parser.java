package parsing;

import external.*;

import invoking.Invoker;
import commandFactory.CommandFactory;
import commandFactory.CommandFactoryInterface;

import java.util.*;
import java.util.function.Consumer;

public class Parser implements Observer, Parse {
    private CommandFactoryInterface myFactory;

    private TreeBuilder myBuilder;
    private TreeExecutor myExecuter;
    private VariableContainer myVars;
    private ResourceContainer myResources;

    private Node commandTree;

    public Parser(CommandFactoryInterface factory, String lang){
        myFactory = factory;
        myResources = new ResourceHandler(lang);
        myVars = new VariableContainer();
        myBuilder = new CommandTreeBuilder();
        myExecuter = new CommandTreeExecutor(myFactory);

    }

    public void parseCommand(String cmd){
        commandTree = myBuilder.buildTree(cmd, myResources);
        myExecuter.executeTree(commandTree.getChildren().get(0), myResources);
    }

    @Override
    public void addVariable(String name, String value) {
        myVars.addVariable(name, value);
    }

    public void update(Observable o, Object arg){
        if(arg instanceof Consumer){
            ((Consumer) arg).accept(this);
        }
        else{
            myExecuter.setReplacementValue((String) arg);
        }
    }

    @Override
    public void changeLanguage(String lang) {
        myResources.changeLanguage(lang);
    }

    @Override
    public void setReplacementValue(String s) {
        myExecuter.setReplacementValue(s);
    }

    public static void main(String args[]){
        Invoker i = new Invoker();
        CommandFactory c = new CommandFactory(i);
        Parser p = new Parser(c, "English");
        p.parseCommand("fd fd 50");
    }
    
}



