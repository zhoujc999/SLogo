package external;

import java.util.List;

public interface TreeBuilder {

    /**
     * Constructs a list of command tree based on the commands given
     * @param commands The supplied commands
     * @param cont The resources used for translation and syntax
     * @return A list of command trees
     */
    public List<Node> buildTrees(String commands, ResourceContainer cont);

}
