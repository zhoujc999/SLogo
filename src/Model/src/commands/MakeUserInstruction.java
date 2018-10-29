package commands;

import external.*;
import parsing.PentaConsumer;

import java.util.List;

public class MakeUserInstruction extends TernaryOperator implements SLogoAbstractExecutable, SLogoConsumerReturnable {
    private final static String ZERO = "0";

    private String commandName;
    private String[] variableList;
    private String commandText;

    private CommandTextWrapper commandContent;
    private PentaConsumer<Parse, TreeExecutor, VariableManipulator, ParameterChangeInterface, Invokable> c;



    public MakeUserInstruction(List params) {
        super(params);
        commandName = super.param1;
        variableList = breakLoopCommands(stripBrackets(param2));
        commandText = stripBrackets(param3);

    }

    private String stripBrackets(String s) {
        return s.substring(1, s.length() - 1);
    }

    private String[] breakLoopCommands(String s) {
        return s.split("\\s");
    }

    @Override
    public void execute(ModelTurtle turtle) {
        c = this::makeCommandFunction;
    }

    @Override
    public PentaConsumer<Parse, TreeExecutor, VariableManipulator, ParameterChangeInterface, Invokable> returnValue() {
        return c;
    }

    private void makeCommandFunction(Parse p, TreeExecutor t, VariableManipulator v, ParameterChangeInterface pci, Invokable inv) {
        commandContent = new CommandTextWrapper(commandName, variableList, commandText);
        v.addCommand(param1, commandContent);
        pci.addCommandParameter(param1, String.valueOf(commandContent.getNumVariables()));
    }

    @Override
    public boolean isStringReturnable() {
        return false;
    }
}
