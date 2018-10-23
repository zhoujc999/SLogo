package commands;

import external.ModelTurtle;
import external.SLogoMathExecutable;
import external.SLogoStringReturnable;

import java.util.List;

public class pi extends Operator implements SLogoMathExecutable, SLogoStringReturnable {

    public pi(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = Math.PI;
    }

    public String returnValue() {
        return Double.toString(this.result);
    }
}
