package External;

/**
 * An interface used for classes that encapsulate the execution of commands.
 */

public interface Invokable {

    /**
     * Used to take in new commands so that they can be executed.
     *
     * @param cmd An object that implements the Executable interface
     */
    public void acceptCommand(Executable cmd);

}
