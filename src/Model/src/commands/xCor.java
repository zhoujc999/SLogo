package commands;

import external.ModelTurtle;
import external.SLogoStringReturnable;
import external.SLogoTurtleExecutable;

import java.util.List;

public class xCor extends Operator implements SLogoTurtleExecutable, SLogoStringReturnable {

    public xCor(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = turtle.getX();
    }

    public String returnValue() {
        return Double.toString(this.result);
    }
}
