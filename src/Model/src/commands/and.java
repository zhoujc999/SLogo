package commands;

import external.ModelTurtle;
import external.SLogoMathExecutable;
import external.SLogoStringReturnable;

import java.util.List;

public class and extends BinaryMathOperator implements SLogoMathExecutable, SLogoStringReturnable {

    public and(List params) {
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

}

