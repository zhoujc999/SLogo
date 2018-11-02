package commands;

import external.SLogoReturnable;
import external.SLogoTurtleExecutable;
import external.ModelTurtle;
import java.util.List;

/**
 * @author Jason Zhou
 */
public class SetPosition extends BinaryDoubleOperator implements SLogoTurtleExecutable, SLogoReturnable {

    public SetPosition(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.c = (p, t, v, pci, inv) -> t.setReplacementValue(Double.toString(turtle.goTo(param1, param2)));
    }
}
