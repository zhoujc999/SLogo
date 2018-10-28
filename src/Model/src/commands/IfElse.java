package commands;

import external.*;
import parsing.QuaConsumer;

import java.util.List;
import java.util.function.Consumer;

public class IfElse extends TernaryOperator implements SLogoAbstractExecutable, SLogoConsumerReturnable {
    private final static String ZERO = "0";

    private double condition;
    private String trueCommands;
    private String falseCommands;

    private QuaConsumer<Parse, TreeExecutor, VariableManipulator, ResourceContainer> c;


    public IfElse(List params) {
        super(params);
        try {
            condition = Double.parseDouble(super.param1);
        }
        catch (ClassCastException | NullPointerException | NumberFormatException e) {
            throw new IllegalArgumentException(String.format("%s Argument to Double Error", this.getClass().getSimpleName()));
        }
        trueCommands = stripBrackets(param2);
        falseCommands = stripBrackets(param3);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        c = (p, t, v, r) -> t.setReplacementValue(ZERO);
        if (condition != 0) {
            c = (p, t, v, r) -> p.parseCommand(trueCommands);
        }
        else {
            c = (p, t, v, r) -> p.parseCommand(falseCommands);
        }
    }

    private String stripBrackets(String s) {
        String newS;
        newS = s.replaceAll("\\s*\\[\\s*", "");
        newS = newS.replaceAll("\\s*\\]\\s*", "");
        return newS;
    }

    @Override
    public QuaConsumer<Parse, TreeExecutor, VariableManipulator, ResourceContainer> returnValue() {
        return c;
    }

    @Override
    public boolean isStringReturnable() {
        return false;
    }
}
