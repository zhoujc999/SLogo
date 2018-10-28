package commands;

import java.util.List;

public class UserDefinedCommand {

    private String[] variables;
    private String commandText;

    public UserDefinedCommand(String[] variableNamesList, String command) {
        variables = variableNamesList;

        commandText = command;
    }

    public List getVariableNamesList() {
        return List.of(variables);
    }

    public String getCommandText() {
        return commandText;
    }

    public int getNumVariables() {
        return  variables.length;
    }
}
