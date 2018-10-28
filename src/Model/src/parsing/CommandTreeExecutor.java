package parsing;

import commandFactory.CommandFactoryInterface;
import external.Node;
import external.ResourceContainer;
import external.TreeExecutor;

import java.util.ArrayList;
import java.util.List;

public class CommandTreeExecutor implements TreeExecutor {

    public static final String COMMAND_KEY = "Command";

    private CommandFactoryInterface myFactory;
    private ResourceContainer myResources;
    private String replacementValue;

    public CommandTreeExecutor(CommandFactoryInterface factory){
        myFactory = factory;
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
            if(nd.getData().equals("MakeVariable")){
                System.out.println("hello");
                parameters.add(children.get(0).getData());
                children.remove(children.get(0));
            }
            for(Node child: children) {
                System.out.println("test");
                executeSubTree(child);
                parameters.add(child.getData());
            }
            myFactory.createCommand(nd.getData(), parameters);
            nd.setData(replacementValue);
        }
    }

    public void setReplacementValue(String s) {
        replacementValue = s;
    }
}
