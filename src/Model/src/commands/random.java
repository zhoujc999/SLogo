package commands;

import external.ModelTurtle;
import external.SLogoMathExecutable;
import external.SLogoRandom;
import external.SLogoStringReturnable;

import java.util.List;
import java.util.Random;

public class random extends UnaryMathOperator implements SLogoMathExecutable, SLogoStringReturnable {

    public random(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = SLogoRandom.getInstance().nextD() * param1;
    }

}
