package commands;

import external.ModelTurtle;
import external.SLogoMathExecutable;
import external.SLogoStringReturnable;

import java.util.List;

public class Power extends BinaryDoubleOperator implements SLogoMathExecutable, SLogoStringReturnable {

    public Power(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = Math.pow(param1, param2);
    }

    public String returnValue() {
        return Double.toString(this.result);
    }
}
