package commands;

import external.*;
import parsing.PentaConsumer;

import java.util.List;

/**
 * @author Jason Zhou
 */

public class ArcTangent extends UnaryDoubleOperator implements SLogoMathExecutable, SLogoReturnable {
    public ArcTangent(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        double angle = this.param1 * (Math.PI / 180);
        this.c = (p, t, v, pci, inv) -> t.setReplacementValue(Double.toString(Math.atan(angle)));
    }
}
