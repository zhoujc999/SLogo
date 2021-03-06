package commands;

import external.ModelTurtle;
import external.SLogoMathExecutable;
import external.SLogoReturnable;

import java.util.List;

/**
 * @author Jason Zhou
 */
public class Tangent extends UnaryDoubleOperator implements SLogoMathExecutable, SLogoReturnable {
    public Tangent(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        double angle = this.param1 * (Math.PI / 180);
        this.c = (p, t, v, pci, inv) -> t.setReplacementValue(Double.toString(Math.tan(angle)));
    }
}
