package external;

import commands.CommandTextWrapper;

public interface VariableAccessor {

    /**
     * Accesses the value of the variable stored in the interface
     * @return The value of the variable
     */
    public String getVariable(String key);

    /**
     * Gets the wrapper for the variable
     * @param key The variable name
     * @return The wrapper for the specified command
     */
    public CommandTextWrapper getCommand(String key);
}
