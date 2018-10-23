package commands;

import external.ModelTurtle;
import external.SLogoStringReturnable;
import external.SLogoTurtleExecutable;

import java.util.List;

public class penUp extends Operator implements SLogoTurtleExecutable, SLogoStringReturnable {


    public penUp(List params) {
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
