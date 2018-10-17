package commands;

import external.ModelTurtle;
import external.SLogoRandom;

import java.util.List;
import java.util.Random;

public class random extends UnaryMathOperator {

    public random(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = SLogoRandom.getInstance().nextD() * param1;
    }

    @Override
    public double returnValue() {
        return result;
    }
}
