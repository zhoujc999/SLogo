package commands;

import external.ModelTurtle;

import java.util.List;

/**
 * This abstract class is the superclass of Commands that takes in 2 parameters which are doubles.
 * Upon instantiation, the parameters are converted to doubles, and the command object throws an exception if it fails.
 * @author Jason Zhou
 */
public abstract class BinaryDoubleOperator extends BinaryOperator {

    protected double param1;
    protected double param2;

    public BinaryDoubleOperator(List params) {
        super(params);
        try {
            param1 = Double.parseDouble(super.param1);
        }
        catch (ClassCastException | NullPointerException | NumberFormatException e) {
            throw new IllegalArgumentException(String.format("%s 1st Argument to Double Error", this.getClass().getSimpleName()));
        }
        try {
            param2 = Double.parseDouble(super.param2);
        }
        catch (ClassCastException | NullPointerException | NumberFormatException e) {
            throw new IllegalArgumentException(String.format("%s 2nd Argument to Double Error", this.getClass().getSimpleName()));
        }
    }

}
