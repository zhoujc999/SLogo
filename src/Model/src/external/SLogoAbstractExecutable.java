package external;

import java.util.function.Consumer;

public interface SLogoAbstractExecutable extends SLogoExecutable {
    /**
     * Returns the command that from the execution of the command object
     */
    public Consumer<Parse> returnValue();
}
