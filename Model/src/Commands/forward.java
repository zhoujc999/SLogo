package Commands;

import External.ModelTurtle;
import External.TurtleExecutable;
import java.util.*;

public class forward implements TurtleExecutable {
    private final static int numParams = 1;
    private ModelTurtle turtle;
    private int distance;



    public forward(List params) {
        if (params.size() != numParams) {
            throw new IllegalArgumentException("Argument Length Error");
        }
        try {
            distance = (int) params.get(0);
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
        this.turtle.move(distance);
    }

    @Override
    public int returnValue() {
        return distance;
    }
}