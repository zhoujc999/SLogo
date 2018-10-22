package commands;

import external.ModelTurtle;
import external.SLogoStringReturnable;
import external.SLogoTurtleExecutable;

import java.util.List;

public class right extends UnaryTurtleOperator implements SLogoTurtleExecutable, SLogoStringReturnable {

    public right(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = turtle.right(param1);
    }

}