package commands;

import external.ModelTurtle;
import external.SLogoMathExecutable;
import external.SLogoStringReturnable;

import java.util.List;

public class Difference extends BinaryDoubleOperator implements SLogoMathExecutable, SLogoStringReturnable {

    public Difference(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = this.param1 - this.param2;
    }

    public String returnValue() {
        return Double.toString(this.result);
    }
}
