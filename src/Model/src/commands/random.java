package commands;

import external.ModelTurtle;
import external.SLogoMathExecutable;
import external.SLogoRandom;
import external.SLogoStringReturnable;

import java.util.List;

public class Random extends UnaryDoubleOperator implements SLogoMathExecutable, SLogoStringReturnable {

    public Random(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = SLogoRandom.getInstance().nextD() * param1;
    }

    public String returnValue() {
        return Double.toString(this.result);
    }
}
