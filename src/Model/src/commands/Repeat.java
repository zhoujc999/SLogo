package commands;

import external.*;
import parsing.PentaConsumer;

import java.util.List;

public class Repeat extends BinaryOperator implements SLogoAbstractExecutable, SLogoConsumerReturnable {
    private final static String ZERO = "0";
    private final static String VARIABLE = ":repcount";
    private final static int START = 0;
    private final static int INCREMENT = 1;
    private int stop;
    private String commands;

    private PentaConsumer<Parse, TreeExecutor, VariableManipulator, ParameterChangeInterface, Invokable> c;

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

    private String stripBrackets(String s) {
        String newS;
        newS = s.replaceAll("^[^a-zA-Z0-9_]*", "");
        newS = newS.replaceAll("[^a-zA-Z0-9_]*$", "");
        return newS;
    }

    private void loopFunction(Parse p, TreeExecutor t, VariableManipulator v, ParameterChangeInterface pci, Invokable inv) {
        t.setReplacementValue(ZERO);
        for (int i = START; i < stop; i += INCREMENT) {
            v.addVariable(VARIABLE, Integer.toString(i));
            p.parseCommand(commands);
        }
    }

    @Override
    public PentaConsumer<Parse, TreeExecutor, VariableManipulator, ParameterChangeInterface, Invokable> returnValue() {
        return c;
    }

    @Override
    public boolean isStringReturnable() {
        return false;
    }

}