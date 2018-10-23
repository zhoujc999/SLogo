package commands;

import external.ModelTurtle;
import external.SLogoBooleanExecutable;
import external.SLogoMathExecutable;
import external.SLogoStringReturnable;

import java.util.List;

import java.util.List;

public class not extends UnaryMathOperator implements SLogoMathExecutable, SLogoStringReturnable {

    public not(List params) {
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

}