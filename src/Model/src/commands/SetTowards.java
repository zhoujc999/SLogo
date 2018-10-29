package commands;

import external.ModelTurtle;
import external.SLogoReturnable;
import external.SLogoTurtleExecutable;

import java.util.List;

public class SetTowards extends BinaryDoubleOperator implements SLogoTurtleExecutable, SLogoReturnable {

    public SetTowards(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.c = (p, t, v, pci, inv) -> t.setReplacementValue(Double.toString(turtle.towards(param1, param2)));
    }

}
