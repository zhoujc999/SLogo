package External;

/**
 * An interface used for classes that encapsulate the procedures with their parameters called by the commands
 */

public interface Executable {

    /**
     * Takes the turtle and manipulates according to the specific command object
     * @param turtle The model of the turtle
     */
    public void execute(ModelTurtle turtle);

    /**
     * Returns the value that from the execution of the command object
     */
    public int returnVal();

}
