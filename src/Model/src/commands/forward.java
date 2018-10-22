package commands;


import external.ModelTurtle;
import external.SLogoTurtleExecutable;

import java.util.List;

public class forward extends UnaryTurtleOperator implements SLogoTurtleExecutable {

    public forward(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = turtle.forward(param1);
    }

}