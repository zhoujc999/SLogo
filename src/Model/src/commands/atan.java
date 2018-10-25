package commands;

import external.ModelTurtle;
import external.SLogoMathExecutable;
import external.SLogoStringReturnable;

import java.util.List;

public class atan extends UnaryDoubleOperator implements SLogoMathExecutable, SLogoStringReturnable {
    public atan(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        double angle = this.param1 * (Math.PI / 180);
        this.result = Math.atan(angle);
    }
    public String returnValue() {
        return Double.toString(this.result);
    }
}
