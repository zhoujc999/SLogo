package commands;

import external.ModelTurtle;
import external.Parse;
import external.SLogoAbstractExecutable;
import external.SLogoConsumerReturnable;

import java.util.List;
import java.util.function.Consumer;

public class Repeat extends BinaryOperator implements SLogoAbstractExecutable, SLogoConsumerReturnable {
    private final static String ZERO = "0";
    private final static String VARIABLE = ":repcount";
    private final static int START = 0;
    private final static int INCREMENT = 1;
    private int stop;
    private String commands;

    private Consumer<Parse> c;

    public Repeat(List params) {
        super(params);
        try {
            stop = (int) Double.parseDouble(super.param1);
        }
        catch (ClassCastException | NullPointerException | NumberFormatException e) {
            throw new IllegalArgumentException(String.format("%s Argument Error", this.getClass().getSimpleName()));
        }
        commands = stripBrackets(param2);
    }



    @Override
    public void execute(ModelTurtle turtle) {
        c = this::loopFunction;
    }

    private String stripBrackets(String s) {
        String newS;
        newS = s.replaceAll("\\s*\\[\\s*", "");
        newS = newS.replaceAll("\\s*\\]\\s*", "");
        return newS;
    }


    private void loopFunction(Parse p) {
        p.setReplacementValue(ZERO);
        for (int i = START; i < stop; i += INCREMENT) {
            p.addVariable(VARIABLE, Integer.toString(i));
            p.parseCommand(commands);
        }
    }

    @Override
    public Consumer<Parse> returnValue() {
        return c;
    }

    @Override
    public boolean isStringReturnable() {
        return false;
    }

}