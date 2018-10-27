package commands;

import external.ModelTurtle;
import external.SLogoMathExecutable;
import external.SLogoStringReturnable;

import java.util.List;

public class Not extends UnaryDoubleOperator implements SLogoMathExecutable, SLogoStringReturnable {

    public Not(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        if (param1 == 0) {
            this.result = 1;
        }
        else {
            this.result = 0;
        }
    }

    public String returnValue() {
        return Double.toString(this.result);
    }
}