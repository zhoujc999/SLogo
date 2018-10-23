package commands;

import external.ModelTurtle;

import java.util.List;

public abstract class BinaryMathOperator {

    private final static int numParams = 2;

    protected double param1;
    protected double param2;
    protected double result;


    public BinaryMathOperator(List params) {
        if (params.size() != numParams) {
            throw new IllegalArgumentException("Argument Length Error");
        }
        try {
            param1 = Double.parseDouble((String) params.get(0));
        }
        catch (ClassCastException | NullPointerException | NumberFormatException e) {
            throw new IllegalArgumentException(String.format("%s 1st Argument Error", this.getClass().getSimpleName()));
        }
        try {
            param2 = Double.parseDouble((String) params.get(1));
        }
        catch (ClassCastException | NullPointerException | NumberFormatException e) {
            throw new IllegalArgumentException(String.format("%s 2nd Argument Error", this.getClass().getSimpleName()));
        }
    }

    public abstract void execute(ModelTurtle turtle);

    public String returnValue() {
        return Double.toString(this.result);
    }
}
