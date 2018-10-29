package commands;

import external.ModelTurtle;
import external.SLogoMathExecutable;
import external.SLogoReturnable;

import java.util.List;

public class Remainder extends BinaryDoubleOperator implements SLogoMathExecutable, SLogoReturnable {

    public Remainder(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        Double result = this.param1 % this.param2;
        this.c = (p, t, v, pci, inv) -> t.setReplacementValue(Double.toString(result));
    }
}