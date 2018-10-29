package commands;

import external.*;
import parsing.PentaConsumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ID extends Operator implements SLogoMultiExecutable, SLogoConsumerReturnable {

    private PentaConsumer<Parse, TreeExecutor, VariableManipulator, ParameterChangeInterface, Invokable> c;

    public ID(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        c = (p, t, v, pci, inv) -> t.setReplacementValue(String.valueOf(turtle.getID()));
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
