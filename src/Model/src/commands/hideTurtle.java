package commands;

import external.ModelTurtle;
import external.SLogoStringReturnable;
import external.SLogoTurtleExecutable;

import java.util.List;


public class HideTurtle extends Operator implements SLogoTurtleExecutable, SLogoStringReturnable {

    public HideTurtle(List params) {
        super(params);

    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = turtle.hide();
    }

    public String returnValue() {
        return Double.toString(this.result);
    }
}