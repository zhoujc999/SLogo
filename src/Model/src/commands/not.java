package commands;

import external.ModelTurtle;
import external.SLogoBooleanExecutable;

import java.util.List;

public class not implements SLogoBooleanExecutable {
    private final static int numParams = 1;
    protected double param1;
    protected double result;


    public not(List params) {
        if (params.size() != numParams) {
            throw new IllegalArgumentException("Argument Length Error");
        }
        try {
            param1 = (double) params.get(0);
        }
        catch (ClassCastException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void execute(ModelTurtle turtle) {
        if (param1 == 0) {
            this.result = 1;
        }
        else {
            this.result = 0;
        }
    }


    @Override
    public double returnValue() {
        return this.result;
    }





}