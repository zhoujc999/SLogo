package commands;

import external.ModelTurtle;
import external.SLogoMathExecutable;
import external.SLogoStringReturnable;

import java.util.List;

public class NaturalLog extends UnaryDoubleOperator implements SLogoMathExecutable, SLogoStringReturnable {
    public NaturalLog(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = Math.log(this.param1);
    }

    public String returnValue() {
        return Double.toString(this.result);
    }
}
