package commands;

import external.ModelTurtle;
import external.Parse;
import external.SLogoAbstractExecutable;
import external.SLogoConsumerReturnable;

import java.util.List;
import java.util.function.Consumer;

public class SLogoFor implements SLogoAbstractExecutable, SLogoConsumerReturnable {
    private final static int numParams = 2;
    private final static int NUMLOOPITEMS = 4;
    private final static String ZERO = "0";

    private String param1;
    private String param2;


    private String variable;
    private int start;
    private int stop;
    private int increment;
    private String commands;

    private Consumer<Parse> c;



    public SLogoFor(List params) {
        if (params.size() != numParams) {
            throw new IllegalArgumentException("Argument Length Error");
        }
        try {
            param1 = (String) params.get(0);
            param2 = (String) params.get(1);
        }
        catch (ClassCastException | NullPointerException | NumberFormatException e) {
            e.printStackTrace();
        }
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
        c = (p) -> loopFunction(p);
    }

    private String stripBrackets(String s) {
        String newS;
        newS = s.replace("\\s*\\[\\s*", "");
        newS = newS.replace("\\s*\\]\\s*", "");
        return newS;
    }

    private String[] breakLoopCommands(String s) {
        return s.split("\\s");
    }

    private void loopFunction(Parse p) {
        p.setReplacementValue(ZERO);
        for (int i = start; i < stop; i += increment) {
            p.addVariable(variable, Integer.toString(i));
            p.parseCommand(commands);
        }
    }

    @Override
    public Consumer<Parse> returnValue() {
        return c;
    }




}

