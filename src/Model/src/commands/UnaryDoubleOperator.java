package commands;

import external.ModelTurtle;

import java.util.List;

public abstract class UnaryDoubleOperator extends UnaryOperator {

    protected double param1;

    public UnaryDoubleOperator(List params) {
        super(params);
        try {
            System.out.println(super.param1);
            param1 = Double.parseDouble(super.param1);
        }
        catch (ClassCastException | NullPointerException | NumberFormatException e) {
            throw new IllegalArgumentException(String.format("%s Argument to Double Error", this.getClass().getSimpleName()));
        }
    }

}
