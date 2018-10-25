package commands;

import external.ModelTurtle;
import external.Parse;
import external.SLogoAbstractExecutable;
import external.SLogoConsumerReturnable;

import java.util.List;
import java.util.function.Consumer;

public class SLogoIfElse extends TernaryOperator implements SLogoAbstractExecutable, SLogoConsumerReturnable {
    private final static String ZERO = "0";

    private double condition;
    private String trueCommands;
    private String falseCommands;

    private Consumer<Parse> c;


    public SLogoIfElse(List params) {
        super(params);
        try {
            condition = Double.parseDouble(super.param1);
        }
        catch (ClassCastException | NullPointerException | NumberFormatException e) {
            throw new IllegalArgumentException(String.format("%s Argument Error", this.getClass().getSimpleName()));
        }
        trueCommands = stripBrackets(param2);
        falseCommands = stripBrackets(param3);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        c = p -> p.setReplacementValue(ZERO);
        if (condition != 0) {
            c = p -> p.parseCommand(trueCommands);
        }
        else {
            c = p -> p.parseCommand(falseCommands);
        }
    }

    private String stripBrackets(String s) {
        String newS;
        newS = s.replace("\\s*\\[\\s*", "");
        newS = newS.replace("\\s*\\]\\s*", "");
        return newS;
    }

    @Override
    public Consumer<Parse> returnValue() {
        return c;
    }
}
