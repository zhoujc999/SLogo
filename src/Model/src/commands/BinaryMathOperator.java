package commands;

import external.ModelTurtle;
import external.SLogoMathExecutable;

import java.util.List;

public abstract class BinaryMathOperator implements SLogoMathExecutable {
    private final static int numParams = 2;
    protected double param1;
    protected double param2;
    protected double result;


    public BinaryMathOperator(List params) {
        if (params.size() != numParams) {
            throw new IllegalArgumentException("Argument Length Error");
        }
        try {
            param1 = (double) params.get(0);
            param2 = (double) params.get(1);
        }
        catch (ClassCastException e) {
            e.printStackTrace();
        }


    }

    @Override
    public abstract void execute(ModelTurtle turtle);

    @Override
    public double returnValue() {
        return result;
    }
}
