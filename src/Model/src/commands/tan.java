package commands;

import external.ModelTurtle;

import java.util.List;

public class tan extends UnaryMathOperator {
    public tan(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        double angle = this.param1 * (Math.PI / 180);
        this.result = Math.tan(angle);
    }

    @Override
    public double returnValue() {
        return result;
    }

}
