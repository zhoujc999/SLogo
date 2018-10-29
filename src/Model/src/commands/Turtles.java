package commands;


import external.*;
import parsing.PentaConsumer;

import java.util.List;

public class Turtles extends Operator implements SLogoMultiExecutable, SLogoReturnable {

    public Turtles(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        c = (p, t, v, pci, inv) -> t.setReplacementValue(String.valueOf(turtle.getNumTurtles()));
    }
}
