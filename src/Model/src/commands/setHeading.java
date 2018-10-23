package commands;

import external.ModelTurtle;
import external.SLogoStringReturnable;
import external.SLogoTurtleExecutable;

import java.util.List;

public class setHeading extends UnaryDoubleOperator implements SLogoTurtleExecutable, SLogoStringReturnable {

    public setHeading(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = turtle.setHeading(param1);
    }

    public String returnValue() {
        return Double.toString(this.result);
    }
}