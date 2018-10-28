package commands;

import external.ModelTurtle;
import external.SLogoMathExecutable;
import external.SLogoStringReturnable;

import java.util.List;

public class And extends BinaryDoubleOperator implements SLogoMathExecutable, SLogoStringReturnable {

    public And(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        if (param1 != 0 && param2 != 0) {
            this.result = 1;
        }
        else {
            this.result = 0;
        }
    }

    public String returnValue() {
        return Double.toString(this.result);
    }

    @Override
    public boolean isStringReturnable() {
        return true;
    }
}

