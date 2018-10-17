package commands;

import external.ModelTurtle;
import external.SLogoTurtleExecutable;

import java.util.List;

public class hideTurtle implements SLogoTurtleExecutable {

    private double result;
    private final static int numParams = 0;


    public hideTurtle(List params) {
        if (params.size() != numParams) {
            throw new IllegalArgumentException("Argument Length Error");
        }

    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = turtle.hide();
    }


    @Override
    public double returnValue() {
        return this.result;
    }

}
