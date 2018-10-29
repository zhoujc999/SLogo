package commands;

import external.*;
import parsing.PentaConsumer;

import java.util.List;

public class MakeVariable extends BinaryOperator implements SLogoAbstractExecutable, SLogoConsumerReturnable {

    private PentaConsumer<Parse, TreeExecutor, VariableManipulator, ParameterChangeInterface, Invokable> c;

    public MakeVariable(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        c = this::makeVariableFunction;
    }

    @Override
    public PentaConsumer<Parse, TreeExecutor, VariableManipulator, ParameterChangeInterface, Invokable> returnValue() {
        return c;
    }

    private void makeVariableFunction(Parse p, TreeExecutor t, VariableManipulator v, ParameterChangeInterface pci, Invokable inv) {
        v.addVariable(param1, param2);
        t.setReplacementValue(param2);
    }

    @Override
    public boolean isStringReturnable() {
        return false;
    }
}
