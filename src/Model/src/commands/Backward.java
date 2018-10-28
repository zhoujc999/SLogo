package commands;

import external.ModelTurtle;
import external.SLogoStringReturnable;
import external.SLogoTurtleExecutable;

import java.util.List;


public class Backward extends UnaryDoubleOperator implements SLogoTurtleExecutable, SLogoStringReturnable {

    public Backward(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = turtle.back(param1);
    }

    public String returnValue() {
        return Double.toString(this.result);
    }
}