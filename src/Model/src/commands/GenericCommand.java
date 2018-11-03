package commands;

import external.*;
import parsing.PentaConsumer;

import java.util.List;

/**
 * This Command object supports user-defined commands.
 * It is instantiated when the user runs a command he/she previously defined.
 * It binds the names of the command parameters to the actual values that is given when the command is run.
 * It passes the command text back to the Parser for another round of parsing.
 * @author Jason Zhou
 */
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

    /**
     * This method puts variables with their associated values in variable map an calls the Parser to parse the stored command text.
     * It then removes the variables from the map after the command is executed.
     * @param p the Parser instance
     * @param t the TreeExecutor instance
     * @param v the VariableManipulator instance
     * @param pci the ParameterChangeInterface instance
     * @param inv the Invoker instance
     */
    private void makeVariableFunction(Parse p, TreeExecutor t, VariableManipulator v, ParameterChangeInterface pci, Invokable inv) {
        t.setReplacementValue(ZERO);
        int index = 0;
        for (String name : commandText.getVariableNamesList()) {
            v.addVariable(name, paramsList.get(index));
            index++;
        }
        p.parseCommand(commandText.getCommandText());
        for (String name : commandText.getVariableNamesList()) {
            v.removeVariable(name);
        }
    }

    public PentaConsumer<Parse, TreeExecutor, VariableManipulator, ParameterChangeInterface, Invokable> returnValue() {
        return c;
    }
}
