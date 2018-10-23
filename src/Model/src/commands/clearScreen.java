package commands;

import external.ModelTurtle;
import external.SLogoStringReturnable;
import external.SLogoTurtleExecutable;

import java.util.List;


public class clearScreen extends Operator implements SLogoTurtleExecutable, SLogoStringReturnable {

    public clearScreen(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = turtle.clearScreen();
    }

    public String returnValue() {
        return Double.toString(this.result);
    }
}
