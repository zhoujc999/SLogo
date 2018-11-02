package commands;

import external.ModelTurtle;
import external.SLogoReturnable;
import external.SLogoTurtleExecutable;

import java.util.List;

/**
 * @author Jason Zhou
 */

public class Forward extends UnaryDoubleOperator implements SLogoTurtleExecutable, SLogoReturnable {

    public Forward(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.c = (p, t, v, pci, inv) -> t.setReplacementValue(Double.toString(turtle.forward(param1)));
    }

}