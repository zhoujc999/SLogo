package commands;

import external.*;
import parsing.PentaConsumer;

import java.util.List;

public abstract class BinaryOperator {
    private final static int NUMPARAMS = 2;
    protected String param1;
    protected String param2;

    protected PentaConsumer<Parse, TreeExecutor, VariableManipulator, ParameterChangeInterface, Invokable> c;


    public BinaryOperator(List params) {
        checkNumParams(params);
        try {
            param1 = (String) params.get(0);
        }
        catch (ClassCastException | NullPointerException | NumberFormatException e) {
            throw new IllegalArgumentException(String.format("%s 1st Argument to String Error", this.getClass().getSimpleName()));
        }
        try {
            param2 = (String) params.get(1);
        }
        catch (ClassCastException | NullPointerException | NumberFormatException e) {
            throw new IllegalArgumentException(String.format("%s 2nd Argument to String Error", this.getClass().getSimpleName()));
        }
    }

    protected String stripBrackets(String s) {
        String newS;
        newS = s.replaceAll("^[^a-zA-Z0-9_]*", "");
        newS = newS.replaceAll("[^a-zA-Z0-9_]*$", "");
        return newS;
    }

    public abstract void execute(ModelTurtle turtle);

    protected void checkNumParams(List p) {
        if (p.size() < NUMPARAMS) {
            throw new IllegalArgumentException(String.format("%s Argument Length Error", this.getClass().getSimpleName()));
        }
    }

    public PentaConsumer<Parse, TreeExecutor, VariableManipulator, ParameterChangeInterface, Invokable> returnValue() {
        return c;
    }
}
