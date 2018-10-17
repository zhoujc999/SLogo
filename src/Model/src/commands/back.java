package commands;

import external.ModelTurtle;
import external.SLogoTurtleExecutable;

import java.util.List;

public class back implements SLogoTurtleExecutable {


    private double param1;
    private double distance;
    private final static int numParams = 1;


    public back(List params) {
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
        this.distance = param1;
        turtle.back(distance);
    }


    @Override
    public double returnValue() {
        return this.distance;
    }


}
