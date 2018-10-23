package commands;

import external.ModelTurtle;
import external.SLogoStringReturnable;
import external.SLogoTurtleExecutable;

import java.util.List;

public class towards extends BinaryDoubleOperator implements SLogoTurtleExecutable, SLogoStringReturnable {

    public towards(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {

        this.result = turtle.towards(param1, param2);
    }

    public String returnValue() {
        return Double.toString(this.result);
    }
}
