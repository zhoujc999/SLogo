package commands;

import external.ModelTurtle;
import external.SLogoMathExecutable;
import external.SLogoStringReturnable;

import java.util.List;

public class sum extends BinaryDoubleOperator implements SLogoMathExecutable, SLogoStringReturnable {

    public sum(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = this.param1 + this.param2;
    }

    public String returnValue() {
        return Double.toString(this.result);
    }
}
