package commands;

import external.ModelTurtle;
import external.SLogoReturnable;
import external.SLogoTurtleExecutable;

import java.util.List;


public class ClearScreen extends Operator implements SLogoTurtleExecutable, SLogoReturnable {

    public ClearScreen(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.c = (p, t, v, pci, inv) -> t.setReplacementValue(Double.toString(turtle.clearScreen()));
    }


}
