package commands;

import external.ModelTurtle;

import java.util.List;

public class atan extends UnaryMathOperator {
    public atan(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        double angle = this.param1 * (Math.PI / 180);
        this.result = Math.atan(angle);
    }

    @Override
    public double returnValue() {
        return result;
    }

}
