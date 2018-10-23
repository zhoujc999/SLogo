package commands;

import external.ModelTurtle;
import external.SLogoStringReturnable;
import external.SLogoTurtleExecutable;

import java.util.List;


public class home extends TurtleOperator implements SLogoTurtleExecutable, SLogoStringReturnable {


    public home(List params) {
        super(params);

    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = turtle.home();
    }

}
