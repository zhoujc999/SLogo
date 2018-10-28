package commands;

import external.ModelTurtle;
import external.SLogoMathExecutable;
import external.SLogoStringReturnable;

import java.util.List;

public class Product extends BinaryDoubleOperator implements SLogoMathExecutable, SLogoStringReturnable {

    public Product(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        this.result = this.param1 * this.param2;
    }

    public String returnValue() {
        return Double.toString(this.result);
    }

    @Override
    public boolean isStringReturnable() {
        return true;
    }
}
