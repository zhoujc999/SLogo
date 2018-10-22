package commands;

import external.ModelTurtle;
import external.SLogoStringReturnable;
import external.SLogoTurtleExecutable;

import java.util.List;

public class penDown implements SLogoTurtleExecutable, SLogoStringReturnable {

    private double result;
    private final static int numParams = 0;


    public penDown(List params) {
        if (params.size() != numParams) {
            throw new IllegalArgumentException("Argument Length Error");
        }

    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = turtle.getPen().penDown();
    }


    @Override
    public String returnValue() {
        return Double.toString(this.result);
    }

}
