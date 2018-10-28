package commands;

import external.*;
import parsing.QuaConsumer;

import java.util.List;
import java.util.function.Consumer;

public class MakeUserInstruction extends TernaryOperator implements SLogoAbstractExecutable, SLogoConsumerReturnable {
    private final static String ZERO = "0";

    private String commandName;
    private String[] variableList;
    private String commandText;

    private CommandTextWrapper commandContent;
    private QuaConsumer<Parse, TreeExecutor, VariableManipulator, ResourceContainer> c;



    public MakeUserInstruction(List params) {
        super(params);
        commandName = super.param1;
        variableList = breakLoopCommands(stripBrackets(param2));
        commandText = stripBrackets(param3);

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

    @Override
    public void execute(ModelTurtle turtle) {
        c = this::makeCommandFunction;
    }

    @Override
    public QuaConsumer<Parse, TreeExecutor, VariableManipulator, ResourceContainer> returnValue() {
        return c;
    }

    private void makeCommandFunction(Parse p, TreeExecutor t, VariableManipulator v, ResourceContainer r) {
        commandContent = new CommandTextWrapper(commandName, variableList, commandText);
        v.addCommand(param1, commandContent);
//        r.addCommand(param1, commandvariablelisnumber (String));
        
    }

    @Override
    public boolean isStringReturnable() {
        return false;
    }
}
