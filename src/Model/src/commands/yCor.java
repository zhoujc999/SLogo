package commands;

import external.ModelTurtle;
import external.SLogoStringReturnable;
import external.SLogoTurtleExecutable;

import java.util.List;

public class yCor extends TurtleOperator implements SLogoTurtleExecutable, SLogoStringReturnable {

    public yCor(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = turtle.getY();
    }

}
