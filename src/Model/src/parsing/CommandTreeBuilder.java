package parsing;

import external.Node;
import external.ResourceContainer;
import external.TreeBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandTreeBuilder implements TreeBuilder {
    public static final String COMMAND_KEY = "Command";
    public static final String CONSTANT_KEY = "Constant";
    public static final String COMMENT_KEY = "Comment";
    public static final String VARIABLE_KEY = "Variable";
    public static final String LIST_START_KEY = "ListStart";
    public static final String LIST_END_KEY = "ListEnd";
    public static final String GROUP_START_KEY = "GroupStart";
    public static final String GROUP_END_KEY = "GroupEnd";
    public static final String DELIMITER_REGEX = "\\n+|\\s+";


    private ResourceContainer myContainer;

    public CommandTreeBuilder(){

    }

    public Node buildTree(String commands, ResourceContainer cont){
        myContainer = cont;
        ArrayList<String> words = new ArrayList<>(Arrays.asList(commands.split(DELIMITER_REGEX)));
        ListNode frst = buildList(words);
        TreeNode root = new TreeNode();
        createSubTree(root, frst);
        return root;
    }

    private ListNode createSubTree(Node buildingNode, ListNode commandNode){
        if(commandNode == null){
            return commandNode;
        }
        String currentWrd = commandNode.getData();
        commandNode = commandNode.getChild();
        String type = myContainer.getType(currentWrd);
        if(type.equals(COMMAND_KEY)){
            return handleCommands(buildingNode, commandNode, currentWrd);
        }
        else if(type.equals(CONSTANT_KEY) || type.equals(VARIABLE_KEY)){
            buildingNode.addChild(new TreeNode(currentWrd));
            return commandNode;
        }
        else if(type.equals(COMMENT_KEY)){
            return createSubTree(buildingNode, commandNode);
        }
        else if(type.equals(LIST_START_KEY)){
            Pair<String, ListNode> result = joinList("[", commandNode);
            buildingNode.addChild(new TreeNode(result.getLeft()));
            return result.getRight();
        }
        else if(type.equals(GROUP_START_KEY)){
            String command = commandNode.getData();
            buildingNode.addChild(new TreeNode(command));
            buildingNode = buildingNode.getChildren().get(0);
            commandNode = commandNode.getChild();
            Pair<Double, ListNode> result = sumGroup(new Double(0), commandNode);
            buildingNode.addChild(new TreeNode(result.getLeft().toString()));
            return result.getRight();
        }
        return null;
    }

    private ListNode handleCommands(Node buildingNode, ListNode commandNode, String currentWrd){
        String translatedWrd = myContainer.getTranslation(currentWrd.toLowerCase());
        int parameterNumber = myContainer.getParameterCount(translatedWrd);
        TreeNode nwNode = new TreeNode(translatedWrd);
        buildingNode.addChild(nwNode);
        for(int i = 0; i < parameterNumber; i++){
            commandNode = createSubTree(nwNode,commandNode);

        }
        return commandNode;
    }

    private Pair<String, ListNode> joinList(String curList, ListNode commandNode){
        if(commandNode == null){
            System.out.println("Error");
        }
        else if(myContainer.getType(commandNode.getData()).equals(LIST_END_KEY)){
            return new Pair<>(curList + " " + commandNode.getData(), commandNode.getChild());
        }
        return joinList(curList + " " + commandNode.getData(), commandNode.getChild());
    }

    private Pair<Double, ListNode> sumGroup(Double num, ListNode commandNode){
        if(commandNode == null){
            System.out.println("Error");
        }
        else if(myContainer.getType(commandNode.getData()).equals(GROUP_END_KEY)){
            return new Pair<>(num, commandNode.getChild());
        }
        return sumGroup(Double.parseDouble(commandNode.getData()), commandNode.getChild());
    }


    private ListNode buildList(List<String> lst){
        ListNode strt = new ListNode();
        ListNode iter = strt;

        for(String str: lst){
            iter.setChild(new ListNode(str));
            iter = iter.getChild();
        }
        return strt.getChild();
    }
}
