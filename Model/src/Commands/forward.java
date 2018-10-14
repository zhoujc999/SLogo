package Commands;

import External.ModelTurtle;
import External.TurtleExecutable;
import java.util.List;

public class forward implements TurtleExecutable {
    private final static int numParams = 1;
    private ModelTurtle turtle;
    private double param1;
    private double distance;



    public forward(List params) {
        if (params.size() != numParams) {
            throw new IllegalArgumentException("Argument Length Error");
        }
        try {
            param1 = (int) params.get(0);
        }
        catch (ClassCastException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void getTurtle(ModelTurtle turtle) {
        this.turtle = turtle;
    }

    @Override
    public void execute() {
        this.distance = this.param1;
        this.turtle.forward(distance);
    }

    @Override
    public double returnValue() {
        return distance;
    }
}