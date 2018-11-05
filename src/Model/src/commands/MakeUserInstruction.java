package commands;

import external.*;
import parsing.PentaConsumer;


import java.util.List;

/**
 * @author Jason Zhou
 */
public class MakeUserInstruction extends TernaryOperator implements SLogoAbstractExecutable, SLogoReturnable {
    private final static String ZERO = "0";
    private final static String ONE = "1";

    private String commandName;
    private String[] variableList;
    private String commandText;

    private CommandTextWrapper commandContent;


    public MakeUserInstruction(List params) {
        super(params);
        commandName = super.param1;
        variableList = breakLoopCommands(stripBrackets(param2));
        commandText = stripBrackets(param3);

    }

    private String[] breakLoopCommands(String s) {
        return s.split("\\s");
    }

    @Override
    public void execute(ModelTurtle turtle) {
        c = this::makeCommandFunction;
    }


    private void makeCommandFunction(Parse p, TreeExecutor t, VariableManipulator v, ParameterChangeInterface pci, Invokable inv) {
        t.setReplacementValue(ZERO);
        commandContent = new CommandTextWrapper(commandName, variableList, commandText);
        v.addCommand(param1, commandContent);
        pci.addCommandParameter(param1, String.valueOf(commandContent.getNumVariables()));
        t.setReplacementValue(ONE);
    }
}
