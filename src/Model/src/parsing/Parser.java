package parsing;

import commandFactory.CommandFactory;
import external.Node;
import external.Parse;
import javafx.scene.control.Alert;

import java.util.MissingResourceException;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import java.util.Map.Entry;
import java.util.List;
import java.util.Collections;
import java.util.AbstractMap.SimpleEntry;

public class Parser implements Parse {
    public static final String ERROR_MESSAGE_PATH = "/languages/Errors";
    public static final String PROPERTIES_PATH = "/languages/";
    public static final String LANGUAGE_ERROR_KEY = "Language";

    private CommandFactory myFactory;
    private ResourceBundle langBundle;
    private ResourceBundle errorBundle;

    private Node commandTree;
    private List<Entry<String, Pattern>> mySymbols;

    public Parser(CommandFactory factory, String lang){
        myFactory = factory;
        errorBundle = ResourceBundle.getBundle(ERROR_MESSAGE_PATH);
        changeLanguage(lang);
    }

    public void parseCommand(String cmd){
        String lines[] = cmd.split("\\r?\\n");
        for(String wrd: lines){
            String type = getSymbol(wrd);
            if(type.equals("Command")){
                
            }
        }

    }

    public void update(Observable o, Object arg){

    }

    public void changeLanguage(String lang){
        try{
            langBundle = ResourceBundle.getBundle(PROPERTIES_PATH + lang);
        }
        catch (MissingResourceException e){
            displayError(e);
        }
    }

    private void addPatterns (String syntax) {
        try {
            var resources = ResourceBundle.getBundle(syntax);
            for (var key : Collections.list(resources.getKeys())) {
                var regex = resources.getString(key);
                mySymbols.add(new SimpleEntry<>(key, Pattern.compile(regex, Pattern.CASE_INSENSITIVE)));
            }
        }
        catch (MissingResourceException e) {
            displayError(e);
        }
    }

    private String getSymbol (String text){

        for (var e : mySymbols) {
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



