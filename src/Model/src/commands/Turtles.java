package commands;


import external.*;
import parsing.PentaConsumer;

import java.util.List;

public class Turtles extends Operator implements SLogoMultiExecutable, SLogoConsumerReturnable {
    private PentaConsumer<Parse, TreeExecutor, VariableManipulator, ParameterChangeInterface, Invokable> c;

    public Turtles(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        c = (p, t, v, pci, inv) -> t.setReplacementValue(String.valueOf(turtle.getNumTurtles()));
    }

    @Override
    public PentaConsumer<Parse, TreeExecutor, VariableManipulator, ParameterChangeInterface, Invokable> returnValue() {
        return c;
    }

    @Override
    public boolean isStringReturnable() {
        return false;
    }
}
