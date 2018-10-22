package commands;

import external.ModelTurtle;
import external.SLogoStringReturnable;
import external.SLogoTurtleExecutable;

import java.util.List;

public class showTurtle implements SLogoTurtleExecutable, SLogoStringReturnable {

    private double result;
    private final static int numParams = 0;


    public showTurtle(List params) {
        if (params.size() != numParams) {
            throw new IllegalArgumentException(String.format("%s Argument Length Error", this.getClass().getSimpleName()));
        }

    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = turtle.show();
    }


    @Override
    public String returnValue() {
        return Double.toString(this.result);
    }

}
