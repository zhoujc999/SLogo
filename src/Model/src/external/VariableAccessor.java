package external;

import commands.CommandTextWrapper;

import java.util.Map;

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


    /**
     * Allows viewing of an iterable set of map entries for all the variables
     * @return an iterable set of map entries for all the variables
     */
    public Iterable<Map.Entry<String, String>> viewVariables();
}
