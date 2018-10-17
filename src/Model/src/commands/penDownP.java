package commands;


import external.ModelTurtle;
import external.SLogoTurtleExecutable;

import java.util.List;

// equivalent to command "pendown?"
public class penDownP implements SLogoTurtleExecutable {

    private double result;
    private final static int numParams = 0;


    public penDownP(List params) {
        if (params.size() != numParams) {
            throw new IllegalArgumentException("Argument Length Error");
        }

    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = turtle.getPenDown();
    }


    @Override
    public double returnValue() {
        return this.result;
    }

}
