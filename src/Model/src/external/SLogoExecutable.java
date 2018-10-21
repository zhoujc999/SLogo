package external;

/**
 * An interface used for classes that encapsulate the procedures with their parameters called by the commands
 */

public interface SLogoExecutable {

    /**
     * Takes the turtle and manipulates according to the specific command object
     */
    public void execute(ModelTurtle turtle);


}
