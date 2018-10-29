package commands;

import external.*;
import parsing.PentaConsumer;

import java.util.List;

public class GenericCommand implements SLogoAbstractExecutable, SLogoReturnable {
    private final static String ZERO = "0";

    private List<String> paramsList;
    private CommandTextWrapper commandText;

    protected PentaConsumer<Parse, TreeExecutor, VariableManipulator, ParameterChangeInterface, Invokable> c;

    public GenericCommand(List params, CommandTextWrapper command) {
        if (params.size() != command.getNumVariables()) {
            throw new IllegalArgumentException(String.format("%s Argument Length Error", command.getCommandName()));
        }
        paramsList = params;
        commandText = command;
    }

    @Override
    public void execute(ModelTurtle turtle) {
        c = this::makeVariableFunction;
    }

    private void makeVariableFunction(Parse p, TreeExecutor t, VariableManipulator v, ParameterChangeInterface pci, Invokable inv) {
        t.setReplacementValue(ZERO);
        int index = 0;
        for (String name : commandText.getVariableNamesList()) {
            v.addVariable(name, paramsList.get(index));
            index++;
        }
        p.parseCommand(commandText.getCommandText());
    }

    public PentaConsumer<Parse, TreeExecutor, VariableManipulator, ParameterChangeInterface, Invokable> returnValue() {
        return c;
    }
}
