package commands;

import external.*;
import parsing.QuaConsumer;

import java.util.List;
import java.util.function.Consumer;

public class GenericCommand implements SLogoAbstractExecutable, SLogoConsumerReturnable {
    private List<String> paramsList;
    private CommandTextWrapper commandText;
    private final static String ZERO = "0";

    private QuaConsumer<Parse, TreeExecutor, VariableManipulator, ParameterChangeInterface> c;

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

    @Override
    public QuaConsumer<Parse, TreeExecutor, VariableManipulator, ParameterChangeInterface> returnValue() {
        return c;
    }

    private void makeVariableFunction(Parse p, TreeExecutor t, VariableManipulator v, ParameterChangeInterface pci) {
        t.setReplacementValue(ZERO);
        int index = 0;
        for (String name : commandText.getVariableNamesList()) {
            v.addVariable(name, paramsList.get(index));
            index++;
        }
        p.parseCommand(commandText.getCommandText());
    }

    @Override
    public boolean isStringReturnable() {
        return false;
    }
}
