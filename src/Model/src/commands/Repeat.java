package commands;

import external.*;
import parsing.QuaConsumer;

import java.util.List;
import java.util.function.Consumer;

public class Repeat extends BinaryOperator implements SLogoAbstractExecutable, SLogoConsumerReturnable {
    private final static String ZERO = "0";
    private final static String VARIABLE = ":repcount";
    private final static int START = 0;
    private final static int INCREMENT = 1;
    private int stop;
    private String commands;

    private QuaConsumer<Parse, TreeExecutor, VariableManipulator, ParameterChangeInterface> c;

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


    private void loopFunction(Parse p, TreeExecutor t, VariableManipulator v, ParameterChangeInterface pci) {
        t.setReplacementValue(ZERO);
        for (int i = START; i < stop; i += INCREMENT) {
            v.addVariable(VARIABLE, Integer.toString(i));
            p.parseCommand(commands);
        }
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