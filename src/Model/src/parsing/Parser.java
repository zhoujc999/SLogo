package parsing;

import external.*;

import commandFactory.CommandFactory;
import commandFactory.CommandFactoryInterface;

import java.util.*;

public class Parser implements Observer, Parse {
    private CommandFactoryInterface myFactory;

    private TreeBuilder myBuilder;
    private TreeExecutor myExecutor;
    private VariableContainer myVars;
    private ResourceHandler myResources;
    private Invokable myInvoker;

    private List<Node> commandTrees;

    public Parser(Invokable invoker, String lang){
        myInvoker = invoker;
        myVars = new VariableContainer();
        myFactory = new CommandFactory(invoker, myVars);
        myResources = new ResourceHandler(lang);
        myBuilder = new CommandTreeBuilder();
        myExecutor = new CommandTreeExecutor(myFactory, myVars);
    }

    @Override
    public void parseCommand(String cmd){
        commandTrees = myBuilder.buildTrees(cmd, myResources);
        myExecutor.executeTrees(commandTrees, myResources);
    }

    @Override
    public void update(Observable o, Object arg){
        ((PentaConsumer) arg).accept(this, myExecutor,  myVars, myResources, myInvoker);
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



