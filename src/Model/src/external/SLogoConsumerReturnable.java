package external;

import parsing.PentaConsumer;

public interface SLogoConsumerReturnable extends SLogoReturnable<PentaConsumer> {
    /**
     * Returns the command that from the execution of the command object
     */
    public PentaConsumer<Parse, TreeExecutor, VariableManipulator, ParameterChangeInterface, Invokable> returnValue();
}
