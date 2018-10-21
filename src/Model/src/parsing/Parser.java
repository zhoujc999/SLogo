package parsing;

import commandFactory.CommandFactory;
import commandFactory.CommandFactoryInterface;
import external.Node;
import external.Parse;
import javafx.scene.control.Alert;

import java.lang.reflect.Parameter;
import java.util.*;
import java.util.regex.Pattern;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleEntry;

public class Parser implements Observer, Parse {
    public static final String ERROR_MESSAGE_PATH = "/languages/Errors";
    public static final String SYNTAX_PATH = "/languages/Syntax";
    public static final String PARAMETER_COUNTS_PATH = "/languages/Command";
    public static final String PROPERTIES_PATH = "/languages/";
    public static final String LANGUAGE_ERROR_KEY = "Language";
    public static final String COMMAND_KEY = "Command";
    public static final String CONSTANT_KEY = "Constant";
    public static final String COMMENT_KEY = "Comment";
    public static final String VARIABLE_KEY = "Variable";
    public static final String LIST_KEY = ""

    private CommandFactoryInterface myFactory;
    private ResourceBundle langBundle;
    private ResourceBundle errorBundle;
    private ResourceBundle paramCountBundle;

    private Node commandTree;
    private Map<String, String> paramMap;
    private Map<String, String> langMap;
    private List<Entry<String, Pattern>> mySyntax;

    private Map<String, String> variableMap;
    private String replacementValue;


    public Parser(CommandFactoryInterface factory, String lang){
        myFactory = factory;
        errorBundle = ResourceBundle.getBundle(ERROR_MESSAGE_PATH);
        paramCountBundle = ResourceBundle.getBundle(PARAMETER_COUNTS_PATH);

        variableMap = new HashMap<>();
        mySyntax = new ArrayList<>();
        changeLanguage(lang);
        paramMap = new HashMap<>();
        createMap(paramMap, paramCountBundle);

        addPatterns(mySyntax, SYNTAX_PATH);
    }

    public void parseCommand(String cmd){

        commandTree = new TreeNode();

        ArrayList<String> words = new ArrayList<>(Arrays.asList(cmd.split(" ")));
        ListNode frst = buildList(words);

        createSubTree(commandTree, frst);
        executeTree((TreeNode) commandTree.getChildren().get(0));
    }

    private ListNode createSubTree(Node buildingNode, ListNode commandNode){
        if(commandNode == null){
            return commandNode;
        }
        String currentWrd = commandNode.getData();
        commandNode = commandNode.getChild();
        String type = getSymbol(mySyntax, currentWrd);
        if(type.equals(COMMAND_KEY)){
            String translatedWrd = langMap.get(currentWrd);
            int parameterNumber = Integer.parseInt(paramMap.get(translatedWrd));
            TreeNode nwNode = new TreeNode(translatedWrd);
            buildingNode.addChild(nwNode);
            for(int i = 0; i < parameterNumber; i++){
                commandNode = createSubTree(nwNode,commandNode);
            }
            return commandNode;
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
            buildingNode.addChild(new TreeNode(variableMap.get(currentWrd)));
        }
        else if(type.equals())
        return null;
    }

    private void executeTree(TreeNode root){
        String type = getSymbol(mySyntax, root.getData());
        if(type.equals(COMMAND_KEY)){
            ArrayList<TreeNode> children = root.getChildren();
            ArrayList<Double> parameters = new ArrayList<>();
            for(TreeNode child: children) {
                executeTree(child);
                parameters.add(Double.parseDouble(child.getData()));
            }
            myFactory.createCommand(root.getData(), parameters);
            root.setData(replacementValue);
        }
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

    public void update(Observable o, Object arg){
        replacementValue = (String) arg;
    }

    public void changeLanguage(String lang){
        try{
            langBundle = ResourceBundle.getBundle(PROPERTIES_PATH + lang);
            langMap = new HashMap<>();
            createMap(langMap, langBundle);
        }
        catch (MissingResourceException e){
            displayError(e);
        }
    }

    private void createMap(Map<String, String> map, ResourceBundle bundle){
        for (var key : Collections.list(bundle.getKeys())) {
            String[] vals = bundle.getString(key).split("\\|");
            for(String val: vals){
                map.put(val, key);
            }
        }
    }

    private void addPatterns (List<Entry<String, Pattern>> lst, String syntax) {
        try {
            var resources = ResourceBundle.getBundle(syntax);
            for (var key : Collections.list(resources.getKeys())) {
                var regex = resources.getString(key);
                lst.add(new SimpleEntry<>(key, Pattern.compile(regex, Pattern.CASE_INSENSITIVE)));
            }
        }
        catch (MissingResourceException e) {
            displayError(e);
        }
    }

    private String getSymbol (List<Entry<String, Pattern>> lst, String text){
        for (var e : lst) {
            if (match(text, e.getValue())) {
                return e.getKey();
            }
        }
        throw new IllegalArgumentException("Invalid Symbol");
    }

    private boolean match (String text, Pattern regex) {
        return regex.matcher(text).matches();
    }

    private void displayError(Exception e){
        String message = errorBundle.getString(LANGUAGE_ERROR_KEY);
        Alert err = new Alert(Alert.AlertType.WARNING, message);
        err.showAndWait();
    }
    
}



