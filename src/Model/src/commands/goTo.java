package commands;

import external.SLogoTurtleExecutable;
import external.ModelTurtle;
import java.util.List;

public class goTo implements SLogoTurtleExecutable {
    private ModelTurtle turtle;

    private double param1;
    private double param2;
    private double x;
    private double y;
    private double distance;
    private final static int numParams = 2;


    public goTo(List params) {
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
        catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            // TODO
        }

    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.turtle = turtle;
        this.x = param1;
        this.y = param2;
        this.distance = turtle.goTo(x, y);
    }


    @Override
    public double returnValue() {
        return this.distance;
    }

}
