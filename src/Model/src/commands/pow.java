package commands;

import external.ModelTurtle;

import java.util.List;

public class pow extends BinaryMathOperator {

    public pow(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = Math.pow(param1, param2);
    }

    @Override
    public double returnValue() {
        return result;
    }

}
