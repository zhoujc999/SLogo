package commands;

import external.ModelTurtle;
import external.SLogoMathExecutable;
import external.SLogoReturnable;

import java.util.List;

public class Power extends BinaryDoubleOperator implements SLogoMathExecutable, SLogoReturnable {

    public Power(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        Double result = Math.pow(param1,param2);
        this.c = (p, t, v, pci, inv) -> t.setReplacementValue(Double.toString(result));
    }
}
