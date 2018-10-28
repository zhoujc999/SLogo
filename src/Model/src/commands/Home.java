package commands;

import external.ModelTurtle;
import external.SLogoStringReturnable;
import external.SLogoTurtleExecutable;

import java.util.List;


public class Home extends Operator implements SLogoTurtleExecutable, SLogoStringReturnable {


    public Home(List params) {
        super(params);

    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = turtle.home();
    }

    public String returnValue() {
        return Double.toString(this.result);
    }

    @Override
    public boolean isStringReturnable() {
        return true;
    }
}
