package external;

import java.util.ArrayList;
import java.util.List;

public interface Node {

    /**
     * Gets the data stored in node
     * @return the data stored in node
     */
    public String getData();

    /**
     * Gets the array list of child nodes of the current node
     * @return the array list of child nodes of the current node
     */
    public List<? extends Node> getChildren();

    /**
     * Adds a new child to the node
     * @param nwChild the new node that is being added as a child of the current node
     */
    public void addChild(Node nwChild);

    /**
     * Sets the data of the current node
     * @param nwData the data of the current node
     */
    public void setData(String nwData);

}
