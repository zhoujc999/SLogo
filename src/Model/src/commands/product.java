package commands;

import external.ModelTurtle;

import java.util.List;

public class product extends BinaryMathOperator {

    public product(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = this.param1 * this.param2;
    }

    @Override
    public double returnValue() {
        return result;
    }

}
