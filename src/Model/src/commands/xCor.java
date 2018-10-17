package commands;

import external.ModelTurtle;
import external.SLogoTurtleExecutable;

import java.util.List;

public class xCor implements SLogoTurtleExecutable {

    private double x;
    private final static int numParams = 0;


    public xCor(List params) {
        if (params.size() != numParams) {
            throw new IllegalArgumentException("Argument Length Error");
        }

    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.x = turtle.getX();
    }


    @Override
    public double returnValue() {
        return this.x;
    }

}
