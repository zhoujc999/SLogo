package commands;

import external.ModelTurtle;
import external.SLogoMathExecutable;
import external.SLogoStringReturnable;

import java.util.List;

public class pi extends MathOperator implements SLogoMathExecutable, SLogoStringReturnable {

    public pi(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = Math.PI;
    }

}
