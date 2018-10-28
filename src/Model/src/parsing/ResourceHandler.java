package parsing;

import external.LanguageInterface;
import external.ResourceContainer;
import javafx.scene.control.Alert;

import java.util.*;
import java.util.regex.Pattern;

public class ResourceHandler implements ResourceContainer, LanguageInterface {
    public static final String PROPERTIES_PATH = "/languages/";
    public static final String SYNTAX_PATH = "/languages/Syntax";
    public static final String PARAMETER_COUNTS_PATH = "/languages/Command";
    public static final String ERROR_MESSAGE_PATH = "/languages/Errors";
    public static final String LANGUAGE_ERROR_KEY = "Language";

    private ResourceBundle langBundle;
    private ResourceBundle paramCountBundle;
    private ResourceBundle errorBundle;

    private Map<String, String> langMap;
    private Map<String, String> paramMap;

    private List<Map.Entry<String, Pattern>> mySyntax;

    public ResourceHandler(String lang){

        mySyntax = new ArrayList<>();

        addPatterns(mySyntax, SYNTAX_PATH);

        errorBundle = ResourceBundle.getBundle(ERROR_MESSAGE_PATH);

        changeLanguage(lang);

        paramCountBundle = ResourceBundle.getBundle(PARAMETER_COUNTS_PATH);
        paramMap = new HashMap<>();
        createMap(paramMap, paramCountBundle);

    }

    @Override
    public String getTranslation(String word) {
        if(langMap.containsKey(word)){
            return langMap.get(word);
        }
        return null;
    }

    @Override
    public String getType (String text){
        for (var e : mySyntax) {
            if (match(text, e.getValue())) {
                return e.getKey();
            }
        }
        throw new IllegalArgumentException("Invalid Symbol");
    }

    @Override
    public void changeLanguage(String nwLang) {
        try{
            langBundle = ResourceBundle.getBundle(PROPERTIES_PATH + nwLang);
            langMap = new HashMap<>();
            createMap(langMap, langBundle);
        }
        catch (MissingResourceException e){
            displayError(e);
        }
    }

    @Override
    public Integer getParameterCount(String command) {
        if(paramMap.containsKey(command)){
            return Integer.parseInt(paramMap.get(command));
        }
        return null;
    }

    private void createMap(Map<String, String> map, ResourceBundle bundle){
        for (var key : Collections.list(bundle.getKeys())) {
            String[] vals = bundle.getString(key).split("\\|");
            for(String val: vals){
                map.put(val, key);
            }
        }
    }

    private void addPatterns (List<Map.Entry<String, Pattern>> lst, String syntax) {
        try {
            var resources = ResourceBundle.getBundle(syntax);
            for (var key : Collections.list(resources.getKeys())) {
                var regex = resources.getString(key);
                lst.add(new AbstractMap.SimpleEntry<>(key, Pattern.compile(regex, Pattern.CASE_INSENSITIVE)));
            }
        }
        catch (MissingResourceException e) {
            displayError(e);
        }
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
