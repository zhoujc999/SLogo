package commands;

import external.ModelTurtle;
import external.SLogoMathExecutable;
import external.SLogoReturnable;

import java.util.List;

/**
 * @author Jason Zhou
 */
public class NaturalLog extends UnaryDoubleOperator implements SLogoMathExecutable, SLogoReturnable {
    public NaturalLog(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        Double result = Math.log(this.param1);
        this.c = (p, t, v, pci, inv) -> t.setReplacementValue(Double.toString(result));
    }

}
