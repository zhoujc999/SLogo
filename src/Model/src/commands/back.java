package commands;

import external.ModelTurtle;
import external.SLogoStringReturnable;
import external.SLogoTurtleExecutable;

import java.util.List;

public class back extends UnaryTurtleOperator implements SLogoTurtleExecutable, SLogoStringReturnable {

    public back(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = turtle.back(param1);
    }

}
