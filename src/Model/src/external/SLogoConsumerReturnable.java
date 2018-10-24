package external;

import java.util.function.Consumer;

public interface SLogoConsumerReturnable extends SLogoReturnable<Consumer> {
    /**
     * Returns the command that from the execution of the command object
     */
    public Consumer<Parse> returnValue();
}
