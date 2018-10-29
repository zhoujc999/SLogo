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
        c = this::getNumTurtlesFunction;
    }

    @Override
    public PentaConsumer<Parse, TreeExecutor, VariableManipulator, ParameterChangeInterface, Invokable> returnValue() {
        return c;
    }

    private void getNumTurtlesFunction(Parse p, TreeExecutor t, VariableManipulator v, ParameterChangeInterface pci, Invokable inv) {
        t.setReplacementValue(inv.getNumTurtles());
    }

    @Override
    public boolean isStringReturnable() {
        return false;
    }
}
