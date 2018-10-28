package external;

public interface TreeExecutor {

    public void executeTree(Node nd, ResourceContainer container);


    /**
     * Changes receives the values of the change
     * @param s
     */

    public void setReplacementValue(String s);

    /**
     * Adds a variable to the map of variables that the parser recognizes
     * @param name The name of the variable being added
     * @param value The value mapped to the variable
     */
    public void addVariable(String name, String value);

}
