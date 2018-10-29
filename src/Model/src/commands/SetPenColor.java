package commands;

import external.ModelTurtle;
import external.SLogoStringReturnable;
import external.SLogoTurtleExecutable;

import java.util.List;

public class SetPenColor extends UnaryDoubleOperator implements SLogoTurtleExecutable, SLogoStringReturnable {

    public SetPenColor(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = turtle.getPen().setColor((int) param1);
    }

    /**
     * Returns the command that from the execution of the command object
     */
    @Override
    public String returnValue() {
        return Double.toString(this.result);
    }

    @Override
    public boolean isStringReturnable() {
        return true;
    }
}
