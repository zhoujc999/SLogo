package commands;

import external.ModelTurtle;
import external.SLogoMathExecutable;
import external.SLogoReturnable;

import java.util.List;

/**
 * @author Jason Zhou
 */
public class Random extends UnaryDoubleOperator implements SLogoMathExecutable, SLogoReturnable {

    public Random(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        Double result = SLogoRandom.getInstance().nextD() * param1;
        this.c = (p, t, v, pci, inv) -> t.setReplacementValue(Double.toString(result));
    }
}
