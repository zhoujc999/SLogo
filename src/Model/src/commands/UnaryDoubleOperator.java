package commands;

import external.ModelTurtle;

import java.util.List;

/**
 * This abstract class is the superclass of Commands that takes in a parameter which is a double.
 * Upon instantiation, the parameter are converted to a double, and the command object throws an exception if it fails.
 * @author Jason Zhou
 */

public abstract class UnaryDoubleOperator extends UnaryOperator {

    protected double param1;

    public UnaryDoubleOperator(List params) {
        super(params);
        try {
            param1 = Double.parseDouble(super.param1);
        }
        catch (ClassCastException | NullPointerException | NumberFormatException e) {
            throw new IllegalArgumentException(String.format("%s Argument to Double Error", this.getClass().getSimpleName()));
        }
    }

}
