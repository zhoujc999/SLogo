package external;

public interface VariableManipulator {

    /**
     * Adds a variable and key to stored variables
     * @param var Name of the variable
     * @param val Value stored in variable
     */
    public void addVariable(String var, String val);

    /**
     * Removes a variable from the stored variables
     * @param var Name of the variable to be removed
     */
    public void removeVariable(String var);
}
