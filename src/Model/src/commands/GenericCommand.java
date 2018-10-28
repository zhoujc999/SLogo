package commands;

import external.ModelTurtle;
import external.Parse;
import external.SLogoAbstractExecutable;
import external.SLogoConsumerReturnable;

import java.util.List;
import java.util.function.Consumer;

public class GenericCommand implements SLogoAbstractExecutable, SLogoConsumerReturnable {
    private List<String> paramsList;
    private CommandTextWrapper commandText;
    private final static String ZERO = "0";

    private Consumer<Parse> c;

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
    public Consumer<Parse> returnValue() {
        return c;
    }

    private void makeVariableFunction(Parse p) {
        p.setReplacementValue(ZERO);
        int index = 0;
        for (String name : commandText.getVariableNamesList()) {
            p.addVariable(name, paramsList.get(index));
            index++;
        }
        p.parseCommand(commandText.getCommandText());
    }
}
