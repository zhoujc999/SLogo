package commands;

import external.ModelTurtle;

import java.util.List;

public abstract class TurtleOperator {

    protected double result;
    private final static int numParams = 0;

    public TurtleOperator(List params) {
        if (params.size() != numParams) {
            throw new IllegalArgumentException("Argument Length Error");
        }

    }

    public abstract void execute(ModelTurtle turtle);

    public String returnValue() {
        return Double.toString(this.result);
    }
}

