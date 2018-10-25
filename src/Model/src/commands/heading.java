package commands;

import external.ModelTurtle;
import external.SLogoStringReturnable;
import external.SLogoTurtleExecutable;

import java.util.List;

public class heading extends Operator implements SLogoTurtleExecutable, SLogoStringReturnable {

    public heading(List params) {
        super(params);

    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = turtle.getHeading();
    }

    public String returnValue() {
        return Double.toString(this.result);
    }
}
