package commands;

import external.ModelTurtle;
import external.SLogoReturnable;
import external.SLogoTurtleExecutable;

import java.util.List;

public class SetHeading extends UnaryDoubleOperator implements SLogoTurtleExecutable, SLogoReturnable {

    public SetHeading(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.c = (p, t, v, pci, inv) -> t.setReplacementValue(Double.toString(turtle.setHeading(param1)));
    }
}