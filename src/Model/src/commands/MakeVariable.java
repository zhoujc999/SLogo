package commands;

import external.*;
import parsing.QuaConsumer;

import java.util.List;
import java.util.function.Consumer;

public class MakeVariable extends BinaryOperator implements SLogoAbstractExecutable, SLogoConsumerReturnable {

    private QuaConsumer<Parse, TreeExecutor, VariableManipulator, ResourceContainer> c;

    public MakeVariable(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        c = this::makeVariableFunction;
    }

    @Override
    public QuaConsumer<Parse, TreeExecutor, VariableManipulator, ResourceContainer> returnValue() {
        return c;
    }

    private void makeVariableFunction(Parse p, TreeExecutor t, VariableManipulator v, ResourceContainer r) {
        v.addVariable(param1, param2);
        t.setReplacementValue(param2);
    }

    @Override
    public boolean isStringReturnable() {
        return false;
    }
}
