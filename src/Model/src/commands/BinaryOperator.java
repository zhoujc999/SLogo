package commands;

import external.*;
import parsing.PentaConsumer;

import java.util.ArrayList;
import java.util.List;

public abstract class BinaryOperator {
    private final static int NUMPARAMS = 2;
    protected List<String> paramStringList;
    protected String param1;
    protected String param2;

    protected PentaConsumer<Parse, TreeExecutor, VariableManipulator, ParameterChangeInterface, Invokable> c;


    public BinaryOperator(List params) {
        checkNumParams(params);

        paramStringList = new ArrayList<>();
        for (int i = 0; i < params.size(); i++) {
            try {
                String param = (String) params.get(i);
                paramStringList.add(param);
            } catch (ClassCastException | NullPointerException | NumberFormatException e) {
                throw new IllegalArgumentException(String.format("%s %d Argument to String Error", this.getClass().getSimpleName(), i + 1));
            }
        }

        param1 = paramStringList.get(0);
        param2 = paramStringList.get(1);
    }

    protected String stripBrackets(String s) {
        String newS;
        newS = s.replaceAll("^[^\\[]*", "");
        newS = newS.replaceAll("[^\\]]*$", "");
        return newS.substring(1, newS.length() - 1);
    }

    public abstract void execute(ModelTurtle turtle);

    protected void checkNumParams(List p) {
        if (p.size() < NUMPARAMS) {
            throw new IllegalArgumentException(String.format("%s Argument Length Error", this.getClass().getSimpleName()));
        }
    }

    public PentaConsumer<Parse, TreeExecutor, VariableManipulator, ParameterChangeInterface, Invokable> returnValue() {
        return c;
    }
}
