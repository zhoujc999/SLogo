package external;
import parsing.PentaConsumer;

/**
 * An interface that exposes the returnValue method of the Command object.
 * This interface is used as the Command object is called to return a Consumer.
 * @author Jason Zhou
 */
public interface SLogoReturnable {

    /**
     * returnValue returns a Consumer that consumes and acts on 5 objects.
     * This method is called by the update method in the Parser.
     * @return PentaConsumer
     */
    public PentaConsumer<Parse, TreeExecutor, VariableManipulator, ParameterChangeInterface, Invokable> returnValue();
}
