package commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This class is a wrapper for the text of the commands defined by the user.
 * It contains the command name, a list of variables that would be used in the command as well as the text of the command.
 * @author Jason Zhou
 */
public class CommandTextWrapper {

    private String commandName;
    private List<String> variables;
    private String commandText;

    CommandTextWrapper(String name, String[] variableNamesList, String command) {
        commandName = name;
        variables = new ArrayList(Arrays.asList(variableNamesList));
        commandText = command;
    }

    /**
     * Accessor for the Command name
     * @return Command name
     */
    public String getCommandName() {
        return commandName;
    }

    /**
     * Accessor for the list of names of variables to be defined when the command is called
     * @return List of variable names
     */
    public List<String> getVariableNamesList() {
        return Collections.unmodifiableList(variables);
    }

    /**
     * Accessor for the command text
     * @return Command text
     */
    public String getCommandText() {
        return commandText;
    }

    /**
     * Accessor for the number of variables the command takes in
     * @return number of variables
     */
    public int getNumVariables() {
        return variables.size();
    }


}
