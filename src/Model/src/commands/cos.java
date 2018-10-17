package commands;

import external.ModelTurtle;

import java.util.List;

public class cos extends UnaryMathOperator {
    public cos(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        double angle = this.param1 * (Math.PI / 180);
        this.result = Math.cos(angle);
    }

    @Override
    public double returnValue() {
        return result;
    }

}
