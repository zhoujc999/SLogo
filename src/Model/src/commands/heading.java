package commands;

import external.ModelTurtle;
import external.SLogoTurtleExecutable;

import java.util.List;

public class heading implements SLogoTurtleExecutable {

    private double degree;
    private final static int numParams = 0;


    public heading(List params) {
        if (params.size() != numParams) {
            throw new IllegalArgumentException("Argument Length Error");
        }

    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.degree = turtle.getHeading();
    }


    @Override
    public double returnValue() {
        return this.degree;
    }

}
