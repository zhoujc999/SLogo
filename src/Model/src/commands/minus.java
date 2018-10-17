package commands;

import external.ModelTurtle;

import java.util.List;

public class minus extends UnaryMathOperator {

    public minus(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = -this.param1;
    }

    @Override
    public double returnValue() {
        return this.result;
    }

}
