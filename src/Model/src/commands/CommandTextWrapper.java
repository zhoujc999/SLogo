package commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CommandTextWrapper {

    private String commandName;
    private List<String> variables;
    private String commandText;

    public CommandTextWrapper(String name, String[] variableNamesList, String command) {
        commandName = name;
        variables = new ArrayList(Arrays.asList(variableNamesList));
        commandText = command;
    }

    public String getCommandName() {
        return commandName;
    }

    public List<String> getVariableNamesList() {
        return Collections.unmodifiableList(variables);
    }

    public String getCommandText() {
        return commandText;
    }

    public int getNumVariables() {
        return  variables.size();
    }
}
