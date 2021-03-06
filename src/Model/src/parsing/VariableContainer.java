package parsing;

import commands.CommandTextWrapper;
import external.VariableAccessor;
import external.VariableManipulator;

import java.util.HashMap;
import java.util.Map;

public class VariableContainer implements VariableManipulator, VariableAccessor {
    private Map<String, String> variableMap;
    private Map<String, CommandTextWrapper> commandMap;


    public VariableContainer(){
        variableMap = new HashMap<>();
        commandMap = new HashMap<>();
    }

    @Override
    public void addVariable(String var, String val) {
        variableMap.put(var, val);
    }

    @Override
    public void removeVariable(String var) {
        if(variableMap.containsKey(var)){
            variableMap.remove(var);
        }
    }

    @Override
    public String getVariable(String var) {
        if(variableMap.containsKey(var)){
            return variableMap.get(var);
        }
        return null;
    }

    @Override
    public void addCommand(String name, CommandTextWrapper command) {
        commandMap.put(name, command);
    }

    @Override
    public CommandTextWrapper getCommand(String key) {
        return commandMap.get(key);
    }

    @Override
    public Iterable<Map.Entry<String, String>> viewVariables() {
        return variableMap.entrySet();
    }

    @Override
    public Iterable<Map.Entry<String, String>> viewCommands() {
        HashMap<String, String> ret = new HashMap<>();
        for(Map.Entry<String, CommandTextWrapper> ent: commandMap.entrySet()){
            ret.put(ent.getKey(), ent.getValue().getCommandText());
        }
        return ret.entrySet();
    }
}
