package commands;

import external.*;
import parsing.PentaConsumer;

import java.util.List;

/**
 * @author Jason Zhou
 */
public class Repeat extends BinaryOperator implements SLogoAbstractExecutable, SLogoReturnable {
    private final static String ZERO = "0";
    private final static String VARIABLE = ":repcount";
    private final static int START = 0;
    private final static int INCREMENT = 1;
    private int stop;
    private String commands;


    public Repeat(List params) {
        super(params);
        try {
            stop = (int) Double.parseDouble(super.param1);
        }
        catch (ClassCastException | NullPointerException | NumberFormatException e) {
            throw new IllegalArgumentException(String.format("%s Argument Error", this.getClass().getSimpleName()));
        }
        commands = stripBrackets(param2);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        c = this::loopFunction;
    }

    private void loopFunction(Parse p, TreeExecutor t, VariableManipulator v, ParameterChangeInterface pci, Invokable inv) {
        t.setReplacementValue(ZERO);
        for (int i = START; i < stop; i += INCREMENT) {
            v.addVariable(VARIABLE, Integer.toString(i));
            p.parseCommand(commands);
        }
        v.removeVariable(VARIABLE);
    }
}