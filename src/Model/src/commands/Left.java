package commands;

import external.ModelTurtle;
import external.SLogoReturnable;
import external.SLogoTurtleExecutable;

import java.util.List;

public class Left extends UnaryDoubleOperator implements SLogoTurtleExecutable, SLogoReturnable {

    public Left(List params) {
        super(params);
    }


    @Override
    public void execute(ModelTurtle turtle) {
        this.c = (p, t, v, pci, inv) -> t.setReplacementValue(Double.toString(turtle.left(param1)));
    }
}