package Commands;

public class Forward implements  {

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