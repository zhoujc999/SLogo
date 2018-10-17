package commands;

import external.ModelTurtle;
import external.SLogoTurtleExecutable;

import java.util.List;

public class clearScreen implements SLogoTurtleExecutable {

    private double distance;
    private final static int numParams = 0;


    public clearScreen(List params) {
        if (params.size() != numParams) {
            throw new IllegalArgumentException("Argument Length Error");
        }

    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.distance = turtle.clearScreen();
    }


    @Override
    public double returnValue() {
        return this.distance;
    }

}
