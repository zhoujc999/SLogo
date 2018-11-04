package commands;

import external.ModelTurtle;
import external.SLogoMathExecutable;
import external.SLogoReturnable;

import java.util.List;

/**
 * @author Jason Zhou
 */
public class Product extends BinaryDoubleOperator implements SLogoMathExecutable, SLogoReturnable {

    public Product(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        Double result = this.param1 * this.param2;
        this.c = (p, t, v, pci, inv) -> t.setReplacementValue(Double.toString(result));
    }
}
