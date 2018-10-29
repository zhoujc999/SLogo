package external;

import commands.CommandTextWrapper;

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

    /**
     * Adds a command to the user defined commands
     * @param name The name of the command
     * @param command The value of the command
     */
    public void addCommand(String name, CommandTextWrapper command);
}
