package commands;

import external.ModelTurtle;
import external.SLogoMathExecutable;
import external.SLogoReturnable;

import java.util.List;

public class Sine extends UnaryDoubleOperator implements SLogoMathExecutable, SLogoReturnable {

    public Sine(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        double angle = this.param1 * (Math.PI / 180);
        this.c = (p, t, v, pci, inv) -> t.setReplacementValue(Double.toString(Math.sin(angle)));
    }
}
