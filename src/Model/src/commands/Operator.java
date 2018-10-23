package commands;

import external.ModelTurtle;

import java.util.List;

public abstract class Operator {

    private final static int NUMPARAMS = 0;

    protected double result;

    public Operator(List params) {
        checkNumParams(params);
    }

    public abstract void execute(ModelTurtle turtle);

    protected void checkNumParams(List p) {
        if (p.size() != NUMPARAMS) {
            throw new IllegalArgumentException("Argument Length Error");
        }
    }
}

