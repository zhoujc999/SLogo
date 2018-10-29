package parsing;

import external.*;

import commandFactory.CommandFactory;
import commandFactory.CommandFactoryInterface;

import java.util.*;
import java.util.function.Consumer;

public class Parser implements Observer, Parse {
    private CommandFactoryInterface myFactory;

    private TreeBuilder myBuilder;
    private TreeExecutor myExecutor;
    private VariableContainer myVars;
    private ResourceHandler myResources;

    private Node commandTree;

    public Parser(Invokable invoker, String lang){
        myVars = new VariableContainer();
        myFactory = new CommandFactory(invoker, myVars);
        myResources = new ResourceHandler(lang);
        myBuilder = new CommandTreeBuilder();
        myExecutor = new CommandTreeExecutor(myFactory, myVars);
    }

    @Override
    public void parseCommand(String cmd){
        commandTree = myBuilder.buildTree(cmd, myResources);
        myExecutor.executeTree(commandTree.getChildren().get(0), myResources);
    }

    @Override
    public void update(Observable o, Object arg){
        if(arg instanceof QuaConsumer){
            ((QuaConsumer) arg).accept(this, myExecutor,  myVars, myResources);
        }
        else{
            myExecutor.setReplacementValue((String) arg);
        }
    }

    @Override
    public VariableAccessor getVariableAccessor() {
        return myVars;
    }

    @Override
    public LanguageInterface getLanguageInterface() {
        return myResources;
    }


}



