package commands;

import external.*;
import parsing.PentaConsumer;

import java.util.List;

/**
 * This abstract class is the superclass of Commands that takes in no parameters.
 * @author Jason Zhou
 */
public abstract class Operator {

    private final static int NUMPARAMS = 0;

    protected PentaConsumer<Parse, TreeExecutor, VariableManipulator, ParameterChangeInterface, Invokable> c;

    public Operator(List params) {
        checkNumParams(params);
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

