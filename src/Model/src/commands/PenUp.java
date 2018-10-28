package commands;

import external.ModelTurtle;
import external.SLogoStringReturnable;
import external.SLogoTurtleExecutable;

import java.util.List;

public class PenUp extends Operator implements SLogoTurtleExecutable, SLogoStringReturnable {


    public PenUp(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = turtle.getPen().penUp();
    }

    public String returnValue() {
        return Double.toString(this.result);
    }
}
