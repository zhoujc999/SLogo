package commands;

import external.ModelTurtle;
import external.SLogoStringReturnable;
import external.SLogoTurtleExecutable;

import java.util.List;

public class forward extends UnaryDoubleOperator implements SLogoTurtleExecutable, SLogoStringReturnable {

    public forward(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = turtle.forward(param1);
    }

    public String returnValue() {
        return Double.toString(this.result);
    }
}