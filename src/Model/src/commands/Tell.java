package commands;

import external.*;
import parsing.PentaConsumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Tell extends UnaryOperator implements SLogoMultiExecutable, SLogoConsumerReturnable {
    private final static String ZERO = "0";

    private List<String> turtlesIDList;
    private PentaConsumer<Parse, TreeExecutor, VariableManipulator, ParameterChangeInterface, Invokable> c;

    public Tell(List params) {
        super(params);
        turtlesIDList = new ArrayList(Arrays.asList(breakIDList(stripBrackets(param1))));
    }

    @Override
    public void execute(ModelTurtle turtle) {
        c = this::tellFunction;
    }

    private String stripBrackets(String s) {
        String newS;
        newS = s.replaceAll("^[^a-zA-Z0-9_]*", "");
        newS = newS.replaceAll("[^a-zA-Z0-9_]*$", "");
        return newS;
    }

    private String[] breakIDList(String s) {
        return s.split("\\s");
    }

    private void tellFunction(Parse p, TreeExecutor t, VariableManipulator v, ParameterChangeInterface pci, Invokable inv) {
        t.setReplacementValue(ZERO);
        inv.activateTurtles(Collections.unmodifiableList(turtlesIDList));
        if (!turtlesIDList.isEmpty()) {
            t.setReplacementValue(turtlesIDList.get(turtlesIDList.size() - 1));
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
