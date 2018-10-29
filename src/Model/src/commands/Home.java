package commands;

import external.ModelTurtle;
import external.SLogoReturnable;
import external.SLogoTurtleExecutable;

import java.util.List;


public class Home extends Operator implements SLogoTurtleExecutable, SLogoReturnable {


    public Home(List params) {
        super(params);

    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.c = (p, t, v, pci, inv) -> t.setReplacementValue(Double.toString(turtle.home()));
    }
}
