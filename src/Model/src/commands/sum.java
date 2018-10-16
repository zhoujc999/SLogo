package commands;

import external.ModelTurtle;
import external.SLogoMathExecutable;
import java.util.List;

public class sum implements SLogoMathExecutable {
    private final static int numParams = 2;
    private double param1;
    private double param2;
    private double result;


    public sum(List params) {
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
    public void execute(ModelTurtle turtle) {
        this.result = this.param1 + this.param2;
    }

    @Override
    public double returnValue() {
        return result;
    }

}