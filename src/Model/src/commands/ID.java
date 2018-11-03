package commands;

import external.*;
import parsing.PentaConsumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jason Zhou
 */
public class ID extends Operator implements SLogoMultiExecutable, SLogoReturnable {

    public ID(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        c = (p, t, v, pci, inv) -> t.setReplacementValue(String.valueOf(turtle.getID()));
    }
}
