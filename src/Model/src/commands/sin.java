package commands;

import external.ModelTurtle;

import java.util.List;

public class sin extends UnaryMathOperator {
    public sin(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        double angle = this.param1 * (Math.PI / 180);
        this.result = Math.sin(angle);
    }

    @Override
    public double returnValue() {
        return result;
    }

}
