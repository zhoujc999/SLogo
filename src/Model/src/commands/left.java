package commands;

import external.ModelTurtle;
import external.SLogoTurtleExecutable;

import java.util.List;

public class left implements SLogoTurtleExecutable {
    private ModelTurtle turtle;

    private double param1;
    private double degree;
    private final static int numParams = 1;


    public left(List params) {
        if (params.size() != numParams) {
            throw new IllegalArgumentException("Argument Length Error");
        }
        try {
            param1 = (double) params.get(0);
        }
        catch (ClassCastException e) {
            e.printStackTrace();
        }
        catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            // TODO
        }

    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.turtle = turtle;
        this.degree = param1;
        turtle.left(degree);
    }


    @Override
    public double returnValue() {
        return this.degree;
    }

}
