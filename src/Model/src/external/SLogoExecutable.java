package external;

/**
 * An interface used for classes that encapsulate the procedures with their parameters called by the commands.
 * All Command objects implement interfaces that extend from the SLogoExecutable interface.
 * @author Jason Zhou
 */

public interface SLogoExecutable {

    /**
     * Takes the turtle And manipulates according to the specific command object
     */
    public void execute(ModelTurtle turtle);


}
