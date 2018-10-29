package external;

import java.util.List;

public interface TreeExecutor {

    /**
     * Executes the provided command trees by calling a command factory
     * @param nd The list of command trees
     * @param container The class that holds behaviors related to translation and syntax
     */
    public void executeTrees(List<Node> nd, ResourceContainer container);


    /**
     * Changes receives the values of the change
     * @param s The replacement value
     */
    public void setReplacementValue(String s);

}
