package commands;

import external.ModelTurtle;
import external.SLogoTurtleExecutable;

import java.util.List;

public class towards implements SLogoTurtleExecutable {

    private double param1;
    private double param2;
    private double x;
    private double y;
    private double degreesTurned;
    private final static int numParams = 2;


    public towards(List params) {
        if (params.size() != numParams) {
            throw new IllegalArgumentException("Argument Length Error");
        }
        try {
            param1 = (double) params.get(0);
            param2 = (double) params.get(1);
        }
        catch (ClassCastException e) {
            e.printStackTrace();
            // TODO
        }


    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.x = param1;
        this.y = param2;
        this.degreesTurned = turtle.towards(x, y);
    }


    @Override
    public double returnValue() {
        return this.degreesTurned;
    }

}
