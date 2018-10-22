package commands;

import external.ModelTurtle;
import external.SLogoBooleanExecutable;
import external.SLogoMathExecutable;
import external.SLogoStringReturnable;

import java.util.List;

public class lessP extends BinaryMathOperator implements SLogoMathExecutable, SLogoStringReturnable {

    public lessP(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        if (param1 < param2) {
            this.result = 1;
        }
        else {
            this.result = 0;
        }
    }

}
