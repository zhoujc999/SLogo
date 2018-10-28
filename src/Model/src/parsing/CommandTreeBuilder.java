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
    private ResourceContainer myContainer;

    public CommandTreeBuilder(){

    }

    public Node buildTree(String commands, ResourceContainer cont){
        myContainer = cont;
        ArrayList<String> words = new ArrayList<>(Arrays.asList(commands.split(" ")));
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
        else if(type.equals(CONSTANT_KEY)){
            TreeNode nwNode = new TreeNode(currentWrd);
            buildingNode.addChild(nwNode);
            return commandNode;
        }
        else if(type.equals(COMMENT_KEY)){
            return createSubTree(buildingNode, commandNode);
        }
        else if(type.equals(VARIABLE_KEY)){
            buildingNode.addChild(new TreeNode(currentWrd));
            return commandNode;
        }
//        else if(type.equals(LIST_START_KEY)){
//            ArrayList<String> listParts = new ArrayList<>();
//            listParts.add(currentWrd);
//            String curType = type;
//            while(!curType.equals(LIST_END_KEY)){
//                listParts.add(commandNode.getData());
//                curType = getSymbol(mySyntax, commandNode.getData());
//                commandNode = commandNode.getChild();
//            }
//
//        }
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
