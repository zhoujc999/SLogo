package commands;

import external.ModelTurtle;
import external.SLogoMathExecutable;
import external.SLogoStringReturnable;

import java.util.List;

public class difference extends BinaryMathOperator implements SLogoMathExecutable, SLogoStringReturnable {

    public difference(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = this.param1 - this.param2;
    }

}
