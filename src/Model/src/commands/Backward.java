package commands;

import external.*;
import parsing.PentaConsumer;

import java.util.List;

/**
 * @author Jason Zhou
 */

public class Backward extends UnaryDoubleOperator implements SLogoTurtleExecutable, SLogoReturnable {

    public Backward(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.c = (p, t, v, pci, inv) -> t.setReplacementValue(Double.toString(turtle.back(param1)));
    }

}