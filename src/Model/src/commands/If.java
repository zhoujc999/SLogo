package commands;

import external.*;
import parsing.PentaConsumer;

import java.util.List;

/**
 * @author Jason Zhou
 */
public class If extends BinaryOperator implements SLogoAbstractExecutable, SLogoReturnable {
    private final static String ZERO = "0";

    private double condition;
    private String commands;


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
        c = (p, t, v, pci, inv) -> t.setReplacementValue(ZERO);
            if (condition != 0) {
                c = (p, t, v, pci, inv) -> p.parseCommand(commands);
            }

    }
}
