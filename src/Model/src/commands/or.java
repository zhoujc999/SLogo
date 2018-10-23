package commands;

import external.ModelTurtle;
import external.SLogoBooleanExecutable;
import external.SLogoMathExecutable;
import external.SLogoStringReturnable;

import java.util.List;

import java.util.List;

public class or extends BinaryMathOperator implements SLogoMathExecutable, SLogoStringReturnable {

    public or(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        if (param1 != 0 || param2 != 0) {
            this.result = 1;
        }
        else {
            this.result = 0;
        }
    }

}