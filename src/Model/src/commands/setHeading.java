package commands;

import external.ModelTurtle;
import external.SLogoStringReturnable;
import external.SLogoTurtleExecutable;

import java.util.List;

public class setHeading extends UnaryTurtleOperator implements SLogoTurtleExecutable, SLogoStringReturnable {

    public setHeading(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = turtle.setHeading(param1);
    }

}
