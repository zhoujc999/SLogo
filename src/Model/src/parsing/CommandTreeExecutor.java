package parsing;

import commandFactory.CommandFactoryInterface;
import external.Node;
import external.ResourceContainer;
import external.TreeExecutor;
import external.VariableAccessor;

import java.util.ArrayList;
import java.util.List;

public class CommandTreeExecutor implements TreeExecutor {

    public static final String COMMAND_KEY = "Command";
    public static final String VARIABLE_KEY = "Variable";
    public static final String MAKE_KEY = "MakeVariable";
    public static final String TO_KEY = "MakeUserInstruction";

    private CommandFactoryInterface myFactory;
    private ResourceContainer myResources;
    private VariableAccessor myVars;
    private String replacementValue;

    public CommandTreeExecutor(CommandFactoryInterface factory, VariableAccessor var){
        myFactory = factory;
        myVars = var;
    }

    @Override
    public void executeTree(Node nd, ResourceContainer container) {
        myResources = container;
        executeSubTree(nd);
    }

    private void executeSubTree(Node nd){
        String type = myResources.getType(nd.getData());
        if(type.equals(COMMAND_KEY)){
            List<? extends Node> children = nd.getChildren();
            ArrayList<String> parameters = new ArrayList<>();
            if(nd.getData().equals(MAKE_KEY) || nd.getData().equals(TO_KEY)){
                parameters.add(children.get(0).getData());
                children.remove(children.get(0));
            }
            for(Node child: children) {
                executeSubTree(child);
                parameters.add(child.getData());
            }
            myFactory.createCommand(nd.getData(), parameters);
            nd.setData(replacementValue);
        }
        if(type.equals(VARIABLE_KEY)){
            nd.setData(myVars.getVariable(nd.getData()));
        }
    }

    @Override
    public void setReplacementValue(String s) {
        replacementValue = s;
    }

}
