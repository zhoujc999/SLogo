package commands;

import external.ModelTurtle;

import java.util.List;

public abstract class UnaryOperator {

    private final static int NUMPARAMS = 1;

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

    public abstract void execute(ModelTurtle turtle);

    protected void checkNumParams(List p) {
        if (p.size() != NUMPARAMS) {
            throw new IllegalArgumentException("Argument Length Error");
        }
    }
}
