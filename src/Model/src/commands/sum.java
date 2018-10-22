package commands;

import external.ModelTurtle;
import external.SLogoMathExecutable;
import external.SLogoStringReturnable;

import java.util.List;

public class sum extends BinaryMathOperator implements SLogoMathExecutable, SLogoStringReturnable {

    public sum(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = this.param1 + this.param2;
    }

}
