package Commands;

import external.TurtleExecutable;

public class Forward implements TurtleExecutable {

    private final static int numParams = 1;
    private final static String PARAM_NAME = "forward";

    public Forward(Queue<String> cmdQueue, Model model,Map<String,Double> variableMap) {
        super(cmdQueue, model, numParams, variableMap);
    }

    @Override
    public double getValue () {
        return myModel.toFront(PARAM_NAME, new double[]{myParams[0].getValue()});
    }

}