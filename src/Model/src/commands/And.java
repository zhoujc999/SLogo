package commands;

import external.*;
import parsing.PentaConsumer;

import java.util.List;

/**
 * @author Jason Zhou
 */

public class And extends BinaryDoubleOperator implements SLogoMathExecutable, SLogoReturnable {
    private final static String ZERO = "0";
    private final static String ONE = "1";

    public And(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        if (param1 != 0 && param2 != 0) {
            this.c = (p, t, v, pci, inv) -> t.setReplacementValue(ONE);
        }
        else {
            this.c = (p, t, v, pci, inv) -> t.setReplacementValue(ZERO);
        }
    }

}

