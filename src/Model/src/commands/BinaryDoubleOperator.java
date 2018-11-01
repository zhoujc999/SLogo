package commands;

import external.ModelTurtle;

import java.util.List;

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
