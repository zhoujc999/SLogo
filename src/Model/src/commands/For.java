package commands;

import external.*;
import parsing.PentaConsumer;

import java.util.List;

public class For extends BinaryOperator implements SLogoAbstractExecutable, SLogoConsumerReturnable {
    private final static int NUMLOOPITEMS = 4;
    private final static String ZERO = "0";


    private String variable;
    private int start;
    private int stop;
    private int increment;
    private String commands;

    private PentaConsumer<Parse, TreeExecutor, VariableManipulator, ParameterChangeInterface, Invokable> c;



    public For(List params) {
        super(params);
        commands = stripBrackets(param2);
        String[] loopList = breakLoopCommands(stripBrackets(param1));
        if (loopList.length != NUMLOOPITEMS) {
            throw new IllegalArgumentException("Loop number of parameters error");
        }
        variable = loopList[0];
        start = (int) Double.parseDouble(loopList[1]);
        stop = (int) Double.parseDouble(loopList[2]);
        increment = (int) Double.parseDouble(loopList[3]);
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

    private String[] breakLoopCommands(String s) {
        return s.split("\\s");
    }

    private void loopFunction(Parse p, TreeExecutor t, VariableManipulator v, ParameterChangeInterface pci, Invokable inv) {
        t.setReplacementValue(ZERO);
        for (int i = start; i <= stop; i += increment) {
            v.addVariable(variable, Integer.toString(i));
            p.parseCommand(commands);
        }
    }

    @Override
    public PentaConsumer<Parse, TreeExecutor, VariableManipulator, ParameterChangeInterface, Invokable> returnValue() {
        return c;
    }

    @Override
    public boolean isStringReturnable() {
        return false;
    }


}

