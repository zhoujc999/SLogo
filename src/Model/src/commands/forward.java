package commands;

import external.ModelTurtle;
import external.SLogoStringReturnable;
import external.SLogoTurtleExecutable;

import java.util.List;

public class forward extends UnaryTurtleOperator implements SLogoTurtleExecutable, SLogoStringReturnable {

    public forward(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = turtle.forward(param1);
    }

}