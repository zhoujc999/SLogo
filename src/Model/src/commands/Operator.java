package commands;

import external.*;
import parsing.PentaConsumer;

import java.util.List;

public abstract class Operator {

    private final static int NUMPARAMS = 0;

    protected PentaConsumer<Parse, TreeExecutor, VariableManipulator, ParameterChangeInterface, Invokable> c;

    public Operator(List params) {
        checkNumParams(params);
    }

    protected String stripBrackets(String s) {
        String newS;
        newS = s.replaceAll("^[^\\[]*", "");
        newS = newS.replaceAll("[^\\]]*$", "");
        return newS.substring(1, newS.length() - 1);
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

