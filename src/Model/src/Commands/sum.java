package Model.src.Commands;

import Model.src.External.MathExecutable;

import java.util.List;

public class sum implements MathExecutable {
    private final static int numParams = 2;
    private double param1;
    private double param2;
    private double result;


    public sum(List params) {
        if (params.size() != numParams) {
            throw new IllegalArgumentException("Argument Length Error");
        }
        try {
            param1 = (int) params.get(0);
            param2 = (int) params.get(1);
        }
        catch (ClassCastException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void execute() {
        this.result = this.param1 + this.param2;
    }

    @Override
    public double returnValue() {
        return result;
    }

}
