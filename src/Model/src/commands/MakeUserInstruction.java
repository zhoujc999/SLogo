package commands;

import external.*;
import parsing.PentaConsumer;
import java.util.regex.Pattern;
import java.util.regex.MatchResult;

import java.util.List;

/**
 * @author Jason Zhou
 */
public class MakeUserInstruction extends TernaryOperator implements SLogoAbstractExecutable, SLogoReturnable {
    private final static String ZERO = "0";
    private final static String ONE = "1";

    private String commandName;
    private String[] variableList;
    private String commandText;

    private CommandTextWrapper commandContent;


    public MakeUserInstruction(List params) {
        super(params);
        commandName = super.param1;
        variableList = breakVariables(stripBrackets(param2));
        commandText = stripBrackets(param3);

    }

    /**
     * https://stackoverflow.com/questions/6020384/create-array-of-regex-matches
     * @param s string to be processed into an array of variables
     * @return  Array of strings.
     */
    private String[] breakVariables(String s) {
        String[] matches = Pattern.compile("(:)\\w+").matcher(s).results().map(MatchResult::group).toArray(String[]::new);
        return matches;
    }

    @Override
    public void execute(ModelTurtle turtle) {
        c = this::makeCommandFunction;
    }


    /**
     *
     * @param p
     * @param t
     * @param v
     * @param pci
     * @param inv
     */
    private void makeCommandFunction(Parse p, TreeExecutor t, VariableManipulator v, ParameterChangeInterface pci, Invokable inv) {
        t.setReplacementValue(ZERO);
        commandContent = new CommandTextWrapper(commandName, variableList, commandText);
        v.addCommand(param1, commandContent);
        pci.addCommandParameter(param1, String.valueOf(commandContent.getNumVariables()));
        t.setReplacementValue(ONE);
    }
}
