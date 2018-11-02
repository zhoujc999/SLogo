package commands;

import external.*;
import parsing.PentaConsumer;

import java.util.List;

/**
 * This abstract class is the superclass of Commands that takes in a parameter.
 * Upon instantiation, the parameter are converted to strings, and the command object throws an exception if it fails.
 * @author Jason Zhou
 */
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
