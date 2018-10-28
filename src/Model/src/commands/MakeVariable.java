package commands;

import external.ModelTurtle;
import external.Parse;
import external.SLogoAbstractExecutable;
import external.SLogoConsumerReturnable;

import java.util.List;
import java.util.function.Consumer;

public class MakeVariable extends BinaryOperator implements SLogoAbstractExecutable, SLogoConsumerReturnable {

    private Consumer<Parse> c;

    public MakeVariable(List params) {
        super(params);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        c = this::makeVariableFunction;
    }

    @Override
    public Consumer<Parse> returnValue() {
        return c;
    }

    private void makeVariableFunction(Parse p) {
        p.addVariable(param1, param2);
        p.setReplacementValue(param2);
    }

    @Override
    public boolean isStringReturnable() {
        return false;
    }
}
