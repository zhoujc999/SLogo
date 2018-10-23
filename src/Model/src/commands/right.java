package commands;

import external.ModelTurtle;
import external.SLogoStringReturnable;
import external.SLogoTurtleExecutable;

import java.util.List;

public class right extends UnaryDoubleOperator implements SLogoTurtleExecutable, SLogoStringReturnable {

    public right(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = turtle.right(param1);
    }

    public String returnValue() {
        return Double.toString(this.result);
    }
}