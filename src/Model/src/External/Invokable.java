package external;
/**
 * An interface used for classes that encapsulate the execution of commands.
 */

public interface Invokable {

    /**
     * Used to take in new commands so that they can be executed.
     *
     * @param cmd An object that implements the SLogoExecutable interface
     */
    public void acceptCommand(SLogoExecutable cmd);

}
