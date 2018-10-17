package commands;

import external.ModelTurtle;
import external.SLogoTurtleExecutable;

import java.util.List;

public class right implements SLogoTurtleExecutable {

    private double param1;
    private double degree;
    private final static int numParams = 1;


    public right(List params) {
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
        this.degree = param1;
        turtle.right(degree);
    }


    @Override
    public double returnValue() {
        return this.degree;
    }

}