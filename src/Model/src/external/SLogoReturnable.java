package external;

import java.util.Objects;

public interface SLogoReturnable <T extends Object> {

    /**
     * Returns the command that from the execution of the command object
     */
    public T returnValue();
}
