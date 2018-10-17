package commands;

import external.ModelTurtle;

import java.util.List;

public class log extends UnaryMathOperator {
    public log(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = Math.log(this.param1);
    }

    @Override
    public double returnValue() {
        return result;
    }

}
