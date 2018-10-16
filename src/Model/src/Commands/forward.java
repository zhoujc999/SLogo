package Commands;


import External.SLogoTurtleExecutable;


import java.util.List;

public class forward implements SLogoTurtleExecutable {
    private External.ModelTurtle turtle;
    private double param1;
    private double distance;
    private final static int numParams = 1;


    public forward(List params) {
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
    public void getTurtle(External.ModelTurtle turtle) {
        this.turtle = turtle;
    }

    @Override
    public void execute() {
        this.distance = param1;
        turtle.forward(distance);
    }

    @Override
    public double returnValue () {
        return  this.distance;
    }

}