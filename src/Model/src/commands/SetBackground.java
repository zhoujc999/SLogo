package commands;

import external.ModelTurtle;
import external.SLogoReturnable;
import external.SLogoTurtleExecutable;
import java.util.List;

/**
 * @author jgp17
 */
public class SetBackground extends UnaryDoubleOperator implements SLogoTurtleExecutable, SLogoReturnable {

    public SetBackground(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        int result = turtle.getBackground().setColor((int) param1);
        this.c = (p, t, v, pci, inv) -> t.setReplacementValue(String.valueOf(result));
    }

}
