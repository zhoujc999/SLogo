package commands;


import external.ModelTurtle;
import external.SLogoReturnable;
import external.SLogoTurtleExecutable;

import java.util.List;

// equivalent to command "pendown?"
public class IsPenDown extends Operator implements SLogoTurtleExecutable, SLogoReturnable {

    public IsPenDown(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.c = (p, t, v, pci, inv) -> t.setReplacementValue(Double.toString(turtle.getPen().getPenDown()));
    }

}
