package commands;

import external.ModelTurtle;

import java.util.List;

public abstract class UnaryDoubleOperator extends UnaryOperator {

    protected double param1;
    protected double result;

    public UnaryDoubleOperator(List params) {
        super(params);
        try {
            param1 = Double.parseDouble(super.param1);
        }
        catch (ClassCastException | NullPointerException | NumberFormatException e) {
            throw new IllegalArgumentException(String.format("%s Argument Error", this.getClass().getSimpleName()));
        }
    }

}