package commands;

import external.ModelTurtle;
import external.SLogoStringReturnable;
import external.SLogoTurtleExecutable;

import java.util.List;

public class showTurtle extends Operator implements SLogoTurtleExecutable, SLogoStringReturnable {

    public showTurtle(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = turtle.show();
    }

    public String returnValue() {
        return Double.toString(this.result);
    }
}
