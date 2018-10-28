package commands;

import external.ModelTurtle;
import external.SLogoStringReturnable;
import external.SLogoTurtleExecutable;

import java.util.List;


public class ClearScreen extends Operator implements SLogoTurtleExecutable, SLogoStringReturnable {

    public ClearScreen(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = turtle.clearScreen();
    }

    public String returnValue() {
        return Double.toString(this.result);
    }

    @Override
    public boolean isStringReturnable() {
        return true;
    }
}
