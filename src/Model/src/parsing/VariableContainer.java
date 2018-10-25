package parsing;

import external.VariableAccessor;
import external.VariableManipulator;

import java.util.HashMap;
import java.util.Map;

public class VariableContainer implements VariableManipulator, VariableAccessor {
    private Map<String, String> variableMap;

    public VariableContainer(){
        variableMap = new HashMap<>();
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

}
