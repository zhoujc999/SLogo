package commands;


import external.ModelTurtle;
import external.SLogoStringReturnable;
import external.SLogoTurtleExecutable;

import java.util.List;

// equivalent to command "pendown?"
public class IsPenDown extends Operator implements SLogoTurtleExecutable, SLogoStringReturnable {

    public IsPenDown(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = turtle.getPen().getPenDown();
    }

    public String returnValue() {
        return Double.toString(this.result);
    }
}
