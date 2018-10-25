package commands;

import external.ModelTurtle;

import java.util.List;

public abstract class TernaryOperator {

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
            throw new IllegalArgumentException(String.format("%s 1st Argument Error", this.getClass().getSimpleName()));
        }
        try {
            param2 = (String) params.get(1);
        }
        catch (ClassCastException | NullPointerException | NumberFormatException e) {
            throw new IllegalArgumentException(String.format("%s 2nd Argument Error", this.getClass().getSimpleName()));
        }
        try {
            param3 = (String) params.get(2);
        }
        catch (ClassCastException | NullPointerException | NumberFormatException e) {
            throw new IllegalArgumentException(String.format("%s 3rd Argument Error", this.getClass().getSimpleName()));
        }
    }


    public abstract void execute(ModelTurtle turtle);

    protected void checkNumParams(List p) {
        if (p.size() != NUMPARAMS) {
            throw new IllegalArgumentException("Argument Length Error");
        }
    }
}
