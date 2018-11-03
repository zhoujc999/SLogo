package commands;

import external.ModelTurtle;
import external.SLogoMathExecutable;
import external.SLogoReturnable;

import java.util.List;

/**
 * @author Jason Zhou
 */
public class Not extends UnaryDoubleOperator implements SLogoMathExecutable, SLogoReturnable {
    private final static String ZERO = "0";
    private final static String ONE = "1";

    public Not(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        if (param1 == 0) {
            this.c = (p, t, v, pci, inv) -> t.setReplacementValue(ONE);
        }
        else {
            this.c = (p, t, v, pci, inv) -> t.setReplacementValue(ZERO);
        }
    }
}