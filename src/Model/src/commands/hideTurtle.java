package commands;

import external.ModelTurtle;
import external.SLogoStringReturnable;
import external.SLogoTurtleExecutable;

import java.util.List;


public class hideTurtle extends TurtleOperator implements SLogoTurtleExecutable, SLogoStringReturnable {

    public hideTurtle(List params) {
        super(params);

    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = turtle.hide();
    }

}