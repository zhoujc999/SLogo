package commands;

import external.*;
import parsing.PentaConsumer;

import java.util.List;

public abstract class UnaryOperator {

    private final static int NUMPARAMS = 1;

    protected PentaConsumer<Parse, TreeExecutor, VariableManipulator, ParameterChangeInterface, Invokable> c;

    protected String param1;

    public UnaryOperator(List params) {
        checkNumParams(params);
        try {
            param1 = (String) params.get(0);
        }
        catch (ClassCastException | NullPointerException | NumberFormatException e) {
            throw new IllegalArgumentException(String.format("%s Argument to String Error", this.getClass().getSimpleName()));
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
        if (p.size() != NUMPARAMS) {
            throw new IllegalArgumentException("Argument Length Error");
        }
    }

    public PentaConsumer<Parse, TreeExecutor, VariableManipulator, ParameterChangeInterface, Invokable> returnValue() {
        return c;
    }
}
