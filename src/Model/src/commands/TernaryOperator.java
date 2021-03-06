package commands;

import external.*;
import parsing.PentaConsumer;

import java.util.List;

/**
 * /**
 *  This abstract class is the superclass of Commands that takes in 3 parameters.
 *  Upon instantiation, the parameters are converted to strings, and the command object throws an exception if it fails.
 *  @author Jason Zhou
 */
public abstract class TernaryOperator {

    protected PentaConsumer<Parse, TreeExecutor, VariableManipulator, ParameterChangeInterface, Invokable> c;

    private final static int NUMPARAMS = 3;
    protected String param1;
    protected String param2;
    protected String param3;

    public TernaryOperator(List params) {
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
        try {
            param3 = (String) params.get(2);
        }
        catch (ClassCastException | NullPointerException | NumberFormatException e) {
            throw new IllegalArgumentException(String.format("%s 3rd Argument to String Error", this.getClass().getSimpleName()));
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
