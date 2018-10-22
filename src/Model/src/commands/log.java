package commands;

import external.ModelTurtle;
import external.SLogoMathExecutable;
import external.SLogoStringReturnable;

import java.util.List;

public class log extends UnaryMathOperator implements SLogoMathExecutable, SLogoStringReturnable {
    public log(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = Math.log(this.param1);
    }

}
