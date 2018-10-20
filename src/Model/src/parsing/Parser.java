package parsing;

import commandFactory.CommandFactory;
import external.Parse;
import javafx.scene.control.Alert;

import java.util.MissingResourceException;
import java.util.Observable;
import java.util.ResourceBundle;

public class Parser implements Parse {
    public static final String ERROR_MESSAGE_PATH = "/languages/Errors";
    public static final String PROPERTIES_PATH = "/languages/";
    public static final String LANGUAGE_ERROR_KEY = "Language";

    private CommandFactory myFactory;
    private ResourceBundle langBundle;
    private ResourceBundle errorBundle;

    public Parser(CommandFactory factory, String lang){
        myFactory = factory;
        errorBundle = ResourceBundle.getBundle(ERROR_MESSAGE_PATH);
        changeLanguage(lang);
    }

    public void parseCommand(String cmd){


    }

    public void update(Observable o, Object arg){

    }

    public void changeLanguage(String lang){
        try{
            langBundle = ResourceBundle.getBundle(PROPERTIES_PATH + lang);
        }
        catch (MissingResourceException e){
            String message = errorBundle.getString(LANGUAGE_ERROR_KEY);
            Alert err = new Alert(Alert.AlertType.WARNING, message);
            err.showAndWait();
        }
    }

}
