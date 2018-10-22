package commands;


import external.ModelTurtle;
import external.SLogoStringReturnable;
import external.SLogoTurtleExecutable;

import java.util.List;

// equivalent to command "pendown?"
public class penDownP extends TurtleOperator implements SLogoTurtleExecutable, SLogoStringReturnable {

    public penDownP(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = turtle.getPen().getPenDown();
    }

}
