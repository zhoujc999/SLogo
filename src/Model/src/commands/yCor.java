package commands;

import external.ModelTurtle;
import external.SLogoTurtleExecutable;

import java.util.List;

public class yCor implements SLogoTurtleExecutable {

    private double y;
    private final static int numParams = 0;


    public yCor(List params) {
        if (params.size() != numParams) {
            throw new IllegalArgumentException("Argument Length Error");
        }

    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.y = turtle.getY();
    }


    @Override
    public double returnValue() {
        return this.y;
    }

}
