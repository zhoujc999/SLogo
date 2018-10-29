package external;

public interface ResourceContainer {

    /**
     * Gets the type of the word provided
     * @param word The original word
     * @return The type of the original word
     */
    public String getType(String word);

    /**
     * Translates the given word
     * @param word The original untranslated word
     * @return The translated word
     */
    public String getTranslation(String word);


    /**
     * Returns the number of parameters needed for the given command
     * @param command The name of the command
     * @return The number of parameters specified
     */
    public Integer getParameterCount(String command);

}
