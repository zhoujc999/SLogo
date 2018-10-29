package commands;


import external.*;
import parsing.QuaConsumer;

import java.util.List;
import java.util.function.Consumer;

public class DoTimes extends BinaryOperator implements SLogoAbstractExecutable, SLogoConsumerReturnable {
    private final static int NUMLOOPITEMS = 2;
    private final static String ZERO = "0";
    private final static int START = 1;
    private final static int INCREMENT = 1;

    private String variable;
    private int stop;
    private String commands;

    //private

    private QuaConsumer<Parse, TreeExecutor, VariableManipulator, ParameterChangeInterface> c;



    public DoTimes(List params) {
        super(params);
        commands = stripBrackets(param2);
        String[] loopList = breakLoopCommands(stripBrackets(param1));
        if (loopList.length != NUMLOOPITEMS) {
            throw new IllegalArgumentException("Loop number of parameters error");
        }
        variable = loopList[0];
        stop = (int) Double.parseDouble(loopList[1]);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        c = this::loopFunction;
    }

    private String stripBrackets(String s) {
        return s.substring(1, s.length() - 1);
    }

    private String[] breakLoopCommands(String s) {
        return s.split("\\s");
    }

    private void loopFunction(Parse p, TreeExecutor t, VariableManipulator v, ParameterChangeInterface pci) {
        t.setReplacementValue(ZERO);
        for (int i = START; i <= stop; i += INCREMENT) {
            v.addVariable(variable, Integer.toString(i));
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
