package commands;

import external.*;
import parsing.PentaConsumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Jason Zhou
 */

public class Ask extends BinaryOperator implements SLogoMultiExecutable, SLogoReturnable {
    private final static String ZERO = "0";

    private List<String> turtlesIDList;
    private String commands;

    //private

    private PentaConsumer<Parse, TreeExecutor, VariableManipulator, ParameterChangeInterface, Invokable> c;

    public Ask(List params) {
        super(params);
        turtlesIDList = new ArrayList(Arrays.asList(breakIDList(stripBrackets(param1))));
        commands = stripBrackets(param2);
    }

    @Override
    public void execute(ModelTurtle turtle) {
        c = this::askFunction;
    }

    private String[] breakIDList(String s) {
        return s.split("\\s");
    }

    private void askFunction(Parse p, TreeExecutor t, VariableManipulator v, ParameterChangeInterface pci, Invokable inv) {
        t.setReplacementValue(ZERO);
        inv.saveActiveState();
        inv.activateTurtles(Collections.unmodifiableList(turtlesIDList));
        p.parseCommand(commands);
        inv.resetActiveState();
    }

}
