package external;

import java.util.function.Consumer;

public interface SLogoStringReturnable extends SLogoReturnable<String> {
    /**
     * Returns the command that from the execution of the command object
     */
    public String returnValue();

}
