package commands;

import external.ModelTurtle;
import external.SLogoStringReturnable;
import external.SLogoTurtleExecutable;

import java.util.List;

public class left extends UnaryTurtleOperator implements SLogoTurtleExecutable, SLogoStringReturnable {

    public left(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = turtle.left(param1);
    }

}