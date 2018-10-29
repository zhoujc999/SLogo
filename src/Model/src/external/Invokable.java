package external;

import java.util.List;

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

    /**
     * Creates and or activates the turtles with the provided ids
     * @param ids A list of ids
     */
    public void activateTurtles(List<String> ids);

    /**
     * Returns the number of turtles created
     * @return the number of turtles created thus far
     */
    public String getNumTurtles();

    /**
     * Saves the current active turtles
     */
    public void saveActiveState();

    /**
     * Resets the currently active turtles
     */
    public void resetActiveState();

}
