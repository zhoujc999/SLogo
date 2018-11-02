package parsing;

/**
 * This functional interface enables the Command objects to call methods that exist in different parts of the model without having a reference to them.
 * @param <T> Parse p
 * @param <U> TreeExecutor t
 * @param <V> VariableManipulator v
 * @param <S> ParameterChangeInterface pci
 * @param <W> Invokable inv
 */
@FunctionalInterface
public interface PentaConsumer<T, U, V, S, W> {
    /**
     * This method accepts the corresponding objects. It executes a block of code that is created when you call execute in the Command Objects
     * @param t Parser p
     * @param u TreeExecutor t
     * @param v VariableManipulator
     * @param s ParameterChangeInterface pc
     * @param w Invokable inv
     */
    public void accept(T t, U u, V v, S s, W w);
}
