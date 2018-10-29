package commands;

import external.*;
import parsing.PentaConsumer;

import java.util.List;

public class IfElse extends TernaryOperator implements SLogoAbstractExecutable, SLogoReturnable {
    private final static String ZERO = "0";

    private double condition;
    private String trueCommands;
    private String falseCommands;

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
        c = (p, t, v, pci, inv) -> t.setReplacementValue(ZERO);
        if (condition != 0) {
            c = (p, t, v, pci, inv) -> p.parseCommand(trueCommands);
        }
        else {
            c = (p, t, v, pci, inv) -> p.parseCommand(falseCommands);
        }
    }
}
