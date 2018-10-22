package commands;

import external.SLogoStringReturnable;
import external.SLogoTurtleExecutable;
import external.ModelTurtle;
import java.util.List;

public class goTo extends BinaryTurtleOperator implements SLogoTurtleExecutable, SLogoStringReturnable {

    public goTo(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = turtle.goTo(param1, param2);
    }

}
