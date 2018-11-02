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
        Double result = this.paramDoubleList.get(0);
        for (int i = 1; i < paramDoubleList.size(); i++) {
            result *= this.paramDoubleList.get(i);
        }
        String resultString = Double.toString(result);
        this.c = (p, t, v, pci, inv) -> t.setReplacementValue(resultString);
    }
}
