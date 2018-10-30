package commands;

import external.ModelTurtle;

import java.util.ArrayList;
import java.util.List;

public abstract class BinaryDoubleOperator extends BinaryOperator {

    protected List<Double> paramDoubleList;
    protected double param1;
    protected double param2;

    public BinaryDoubleOperator(List params) {
        super(params);


        paramDoubleList = new ArrayList<>();
        for (int i = 0; i < params.size(); i++) {
            try {
                Double param = Double.parseDouble(paramStringList.get(i));
                paramDoubleList.add(param);
            }
            catch (ClassCastException | NullPointerException | NumberFormatException e) {
                throw new IllegalArgumentException(String.format("%s %d Argument to Double Error", this.getClass().getSimpleName(), i + 1));
            }
        }

        param1 = paramDoubleList.get(0);
        param2 = paramDoubleList.get(1);

    }

}
