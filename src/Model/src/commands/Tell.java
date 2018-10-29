package commands;

import external.*;
import parsing.PentaConsumer;

import java.util.List;

public class Tell extends UnaryOperator implements SLogoMultiExecutable, SLogoConsumerReturnable {

    String[] turtlesIDList;
    private PentaConsumer<Parse, TreeExecutor, VariableManipulator, ParameterChangeInterface, Invokable> c;

    public Tell(List params) {
        super(params);
        turtlesIDList = breakIDList(stripBrackets(param1));
    }


    private String stripBrackets(String s) {
        String newS;
        newS = s.replaceAll("\\s*\\[\\s*", "");
        newS = newS.replaceAll("\\s*\\]\\s*", "");
        return newS;
    }

    private String[] breakIDList(String s) {
        return s.split("\\s");
    }

}
