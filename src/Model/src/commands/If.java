package commands;

import external.*;
import parsing.QuaConsumer;

import java.util.List;
import java.util.function.Consumer;

public class If extends BinaryOperator implements SLogoAbstractExecutable, SLogoConsumerReturnable {
    private final static String ZERO = "0";

    private double condition;
    private String commands;

    private QuaConsumer<Parse, TreeExecutor, VariableManipulator, ParameterChangeInterface> c;


    public If(List params) {
        super(params);
        try {
            condition = Double.parseDouble(super.param1);
        }
        catch (ClassCastException | NullPointerException | NumberFormatException e) {
            throw new IllegalArgumentException(String.format("%s Argument to Double Error", this.getClass().getSimpleName()));
        }
        commands = stripBrackets(param2);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        c = (p, t, v, r) -> t.setReplacementValue(ZERO);
            if (condition != 0) {
                c = (p, t, v, r) -> p.parseCommand(commands);
            }

    }

    private String stripBrackets(String s) {
        String newS;
        newS = s.replaceAll("\\s*\\[\\s*", "");
        newS = newS.replaceAll("\\s*\\]\\s*", "");
        return newS;
    }

    @Override
    public QuaConsumer<Parse, TreeExecutor, VariableManipulator, ParameterChangeInterface> returnValue() {
        return c;
    }

    @Override
    public boolean isStringReturnable() {
        return false;
    }
}
