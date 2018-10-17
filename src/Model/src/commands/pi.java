package commands;

import external.ModelTurtle;
import external.SLogoMathExecutable;

import java.util.List;

public class pi implements SLogoMathExecutable {

    private double result;
    private final static int numParams = 0;

    public pi(List params) {
        if (params.size() != numParams) {
            throw new IllegalArgumentException("Argument Length Error");
        }

    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = Math.PI;
    }

    @Override
    public double returnValue() {
        return this.result;
    }

}
