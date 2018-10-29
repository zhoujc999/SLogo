package external;

import java.util.ArrayList;

public interface TreeExecutor {

    public void executeTrees(ArrayList<Node> nd, ResourceContainer container);


    /**
     * Changes receives the values of the change
     * @param s
     */

    public void setReplacementValue(String s);

}
