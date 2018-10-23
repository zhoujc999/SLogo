package commands;

import external.ModelTurtle;
import external.SLogoStringReturnable;
import external.SLogoTurtleExecutable;

import java.util.List;

// equivalent to command "showing?"
public class showingP extends Operator implements SLogoTurtleExecutable, SLogoStringReturnable {

    public showingP(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = turtle.getShowing();
    }

    public String returnValue() {
        return Double.toString(this.result);
    }
}
