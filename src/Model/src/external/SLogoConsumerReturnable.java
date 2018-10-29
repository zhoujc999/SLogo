package external;

import parsing.QuaConsumer;

import java.util.function.Consumer;

public interface SLogoConsumerReturnable extends SLogoReturnable<QuaConsumer> {
    /**
     * Returns the command that from the execution of the command object
     */
    public QuaConsumer<Parse, TreeExecutor, VariableManipulator, ParameterChangeInterface> returnValue();
}
