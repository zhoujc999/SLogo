package commands;

import external.ModelTurtle;
import external.SLogoStringReturnable;
import external.SLogoTurtleExecutable;

import java.util.List;

public class PenDown extends Operator implements SLogoTurtleExecutable, SLogoStringReturnable {

    public PenDown(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = turtle.getPen().penDown();
    }

    public String returnValue() {
        return Double.toString(this.result);
    }
}
