package commands;

import external.*;
import parsing.PentaConsumer;

import java.util.List;

public class MakeVariable extends BinaryOperator implements SLogoAbstractExecutable, SLogoReturnable {

    public MakeVariable(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        c = this::makeVariableFunction;
    }



    private void makeVariableFunction(Parse p, TreeExecutor t, VariableManipulator v, ParameterChangeInterface pci, Invokable inv) {
        v.addVariable(param1, param2);
        t.setReplacementValue(param2);
    }

}
