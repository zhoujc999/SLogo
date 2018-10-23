package commands;

import external.ModelTurtle;

import java.util.List;

public abstract class TurtleOperator {

    protected double result;
    private final static int NUMPARAMS = 0;

    public TurtleOperator(List params) {
        checkNumParams(params);
    }

    public abstract void execute(ModelTurtle turtle);

    protected void checkNumParams(List p) {
        if (p.size() != NUMPARAMS) {
            throw new IllegalArgumentException("Argument Length Error");
        }
    }

    public String returnValue() {
        return Double.toString(this.result);
    }
}

